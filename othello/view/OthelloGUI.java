package othello.view;

import javax.swing.JFrame;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame {

    private OthelloController controller;
    private BoardView board;

    public OthelloGUI(OthelloController controller) {
	super("Othello");

	setController(controller);

	setDefaultCloseOperation(EXIT_ON_CLOSE);

	Occupation[][] fieldViewOccupations = new Occupation[8][8];
	Occupation.fill(fieldViewOccupations, Occupation.NONE);
	board = new BoardView(this, fieldViewOccupations);
	add(board);

	pack();

	setVisible(true);
    }

    public OthelloController getController() {
	return controller;
    }

    public void setController(OthelloController controller) {
	this.controller = controller;
    }

    public BoardView getBoard() {
	return board;
    }

    public void setBoard(BoardView board) {
	this.board = board;
    }
}
