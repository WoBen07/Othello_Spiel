package othello.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    public BoardView() {
	setLayout(new GridLayout(8, 8));

	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		add(new FieldView(i, j));
	    }
	}
    }
}
