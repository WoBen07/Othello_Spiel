package othello;

import javax.swing.JFrame;

public class OthelloGUI extends JFrame {
    private Board board = new Board();
    
    public OthelloGUI() {
	super("Othello");
	add(board);
    }
}
