package othello.model;

public class OthelloModel {

    private BoardModel board;

    public OthelloModel(BoardModel board) {
	this.board = board;
    }

    public void updateOccupation(int xPosition, int yPosition) {
	board.updateOccupation(xPosition, yPosition);
    }
}
