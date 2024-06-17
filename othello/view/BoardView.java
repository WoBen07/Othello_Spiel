package othello.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private OthelloController controller;

    public BoardView(OthelloController controller) {
	this.controller = controller;

	setLayout(new GridLayout(8, 8));

	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		add(new FieldView(controller, i, j));
	    }
	}
    }
}
