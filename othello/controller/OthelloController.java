package othello.controller;

import othello.Occupation;
import othello.model.BoardModel;
import othello.view.BoardView;
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
	} else {
	    getBoard().getFields()[xPosition][yPosition]
		    .setOccupation(Occupation.WHITE);
	}
	updateBoardView();
    }

    public void updateBoardView() {
	gui.add(new BoardView(getBoard().getOccupations(), this));
	gui.pack();
    }
}
