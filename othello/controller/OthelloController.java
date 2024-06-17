package othello.controller;

import othello.Occupation;
import othello.model.BoardModel;
import othello.view.OthelloGUI;

public class OthelloController {

    private OthelloGUI gui;
    private BoardModel board;

    public OthelloGUI getGUI() {
	return gui;
    }

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
    }

    public BoardModel getBoard() {
	return board;
    }

    public void setBoard(BoardModel board) {
	this.board = board;
    }

    public void onField(int xPosition, int yPosition) {
	if (getBoard().isBlacksTurn()) {
	    getBoard().getFields()[xPosition][yPosition]
		    .setOccupation(Occupation.BLACK);
	    updateFieldView(xPosition, yPosition, Occupation.BLACK);
	} else {
	    getBoard().getFields()[xPosition][yPosition]
		    .setOccupation(Occupation.WHITE);
	    updateFieldView(xPosition, yPosition, Occupation.WHITE);
	}
    }

    public void updateFieldView(int xPosition, int yPosition,
	    Occupation occupation) {

	gui.getBoard().getFields()[xPosition][yPosition]
		.occupationChange(occupation);
    }
}
