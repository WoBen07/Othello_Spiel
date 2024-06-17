package othello.controller;

import othello.Occupation;
import othello.model.BoardModel;

public class OthelloController {
    
    private BoardModel board;
    
    public OthelloController(BoardModel board) {
	this.board = board;
    }
    
    public BoardModel getBoard() {
	return board;
    }
    
    public void fieldClicked(int xPosition, int yPosition) {
	updateOccupation(xPosition, yPosition);
    }
    
    public void updateOccupation(int xPosition, int yPosition) {
	if (getBoard().isBlacksTurn()) {
	    getBoard().getFields()[xPosition][yPosition].setOccupation(Occupation.BLACK);
	} else {
	    getBoard().getFields()[xPosition][yPosition].setOccupation(Occupation.WHITE);
	}
    }
}
