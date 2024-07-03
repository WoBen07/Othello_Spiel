package othello.controller;

import othello.Piece;
import othello.model.BoardModel;
import othello.view.BoardView;
import othello.view.OthelloGUI;

public class OthelloController {

    private static OthelloController unique;

    private OthelloGUI gui;
    private BoardModel model;

    private OthelloController() {
	initView();
    }

    public static OthelloController instance() {
	if (unique == null) {
	    unique = new OthelloController();
	}
	return unique;
    }

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
    }

    public void setModel(BoardModel model) {
	this.model = model;
	gui.setBoard(new BoardView(gui, model.getPieceFormation()));
	model.addPropertyChangeListener(gui);
    }

    public void initView() {
	setGUI(new OthelloGUI(this));
    }

    public void newGame() {
	setModel(new BoardModel());
	gui.showBoard();
    }

    public void loadGame(String name) {
	setModel(new BoardModel()); // TODO Konstruktor mit Attributen des zu
				    // ladenden Spiels aufrufen
    }

    public void fieldClicked(int xPosition, int yPosition) {
	if (model.hasLegalMove()) {
	    if (model.getLegalMoves()[xPosition][yPosition]) {
		model.updatePieceFormation(xPosition, yPosition,
			(model.isDarksTurn() ? Piece.DARK : Piece.LIGHT));
		model.flipPieces(xPosition, yPosition);
		model.setPassPlayed(false);
		model.switchTurns();
	    }
	} else if (model.wasPassPlayed()) {
	    model.stopGame();
	} else {
	    model.setPassPlayed(true);
	    model.switchTurns();
	    if (!model.hasLegalMove()) {
		model.stopGame();
	    }
	}
    }
}
