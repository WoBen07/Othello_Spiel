package othello.controller;

import javax.swing.JOptionPane;

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

    public OthelloGUI getGUI() {
	return gui;
    }

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
    }

    public BoardModel getModel() {
	return model;
    }

    public void setModel(BoardModel model) {
	this.model = model;
    }

    public void initModel() {
	setModel(new BoardModel(Piece.startFormation()));
    }

    public void initView() {
	setGUI(new OthelloGUI(this));
	getGUI().setBoard(
		new BoardView(getGUI(), getModel().getPieceFormation()));
	getGUI().pack();
    }

    public void fieldClicked(int xPosition, int yPosition) {
	// Wenn es einen legalen Zug gibt
	if (getModel().hasLegalMoves()) {
	    // Wenn der ausgewählte Zug legal ist
	    if (getModel().getLegalMoves()[xPosition][yPosition]) {
		updateFieldModel(xPosition, yPosition,
			(getModel().isDarksTurn() ? Piece.DARK : Piece.LIGHT));
		getModel().flipPieces(xPosition, yPosition);
		getModel().setPassPlayed(false);
		getModel().switchTurns();
	    }
	} else {
	    if (getModel().wasPassPlayed()) {
		JOptionPane.showMessageDialog(getGUI(), "Game End");
	    } else {
		JOptionPane.showMessageDialog(getGUI(),
			"No legal moves, you have to pass", null,
			JOptionPane.INFORMATION_MESSAGE);
		getModel().setPassPlayed(true);
		getModel().switchTurns();
		if (!getModel().hasLegalMoves()) {
		    JOptionPane.showMessageDialog(getGUI(), "Game End");
		}
	    }
	}

    }

    public void updateFieldModel(int xPosition, int yPosition, Piece newPiece) {

	getModel().updatePieceFormation(xPosition, yPosition, newPiece);
    }
}
