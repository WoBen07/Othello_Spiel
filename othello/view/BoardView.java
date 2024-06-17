package othello.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import othello.Occupation;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private final Occupation[][] fieldOccupations;

    public BoardView(Occupation[][] fieldOccupations) {
	this.fieldOccupations = fieldOccupations;

	setLayout(new GridLayout(8, 8));

	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		add(new FieldView(i, j, fieldOccupations[i][j]));
	    }
	}
    }
}
