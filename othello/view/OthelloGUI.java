package othello.view;

import javax.swing.JFrame;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame {

    private final BoardView board;

    public OthelloGUI(OthelloController controller) {
	super("Othello");

	setDefaultCloseOperation(EXIT_ON_CLOSE);

	board = new BoardView(new Occupation[8][8], controller);
	add(board);

	pack();

	setVisible(true);
    }

    public BoardView getBoard() {
	return board;
    }
}
