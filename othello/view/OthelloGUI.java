package othello.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame {

    public OthelloGUI() {
	super("Othello");
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	add(new BoardView());

	pack();

	setVisible(true);
    }
    
    public static void updateGUI() {
	
    }
}
