package othello.controller;

import othello.Piece;
import othello.model.BoardModel;
import othello.view.BoardView;
import othello.view.OthelloGUI;

public class OthelloController {

    private OthelloGUI gui;
    private BoardModel model;

    public OthelloController() {
	initModel();
	initView();
    }

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
    }

    public void setModel(BoardModel model) {
	this.model = model;
    }

    public void initModel() {
	setModel(new BoardModel(Piece.startFormation()));
    }

    public void initView() {
	setGUI(new OthelloGUI(this));
	gui.setBoard(new BoardView(gui, model.getPieceFormation()));
	model.addPropertyChangeListener(gui);

	gui.showBoard();
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
