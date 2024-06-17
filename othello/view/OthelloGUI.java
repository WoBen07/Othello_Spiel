package othello.view;

import javax.swing.JFrame;

import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame {

    public OthelloGUI(OthelloController controller) {
	super("Othello");

	setDefaultCloseOperation(EXIT_ON_CLOSE);

	add(new BoardView(controller));

	pack();

	setVisible(true);
    }
}
