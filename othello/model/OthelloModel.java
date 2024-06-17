package othello.model;

import othello.controller.OthelloController;
import othello.view.OthelloGUI;

public class OthelloModel {

    private OthelloGUI gui;
    private BoardModel board;

    public OthelloModel(OthelloGUI gui, BoardModel board) {
	this.gui = gui;
	this.board = board;
    }

    public void updateOccupation(int xPosition, int yPosition) {
	board.updateOccupation(xPosition, yPosition);
	OthelloController.updateGUI(gui, board.getOccupations());
    }
}
