package othello.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private final FieldView[][] fields = new FieldView[8][8];

    public BoardView(Occupation[][] occupations, OthelloController controller) {

	setLayout(new GridLayout(8, 8));

	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fields[i][j] = new FieldView(i, j, occupations[i][j], controller);
		add(fields[i][j]);
	    }
	}
    }
}
