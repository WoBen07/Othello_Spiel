package othello.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    public BoardView() {
	setLayout(new GridLayout(8, 8));

	for (int i = 0; i < 64; ++i) {
	    add(new FieldView());
	}
    }
}
