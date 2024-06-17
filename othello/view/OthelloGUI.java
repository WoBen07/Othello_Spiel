package othello.view;

import javax.swing.JFrame;

import othello.Occupation;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame {

    public OthelloGUI(Occupation[][] fieldOccupations) {
	super("Othello");
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	add(new BoardView(fieldOccupations));

	pack();

	setVisible(true);
    }
}
