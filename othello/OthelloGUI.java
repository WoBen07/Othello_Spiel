package othello;

import javax.swing.JFrame;

public class OthelloGUI extends JFrame {

    private Board board;

    public OthelloGUI() {
	super("Othello");
    board = new Board();
	this.add(board);
    }


}
