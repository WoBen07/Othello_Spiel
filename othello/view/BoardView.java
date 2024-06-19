package othello.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private final FieldView[][] fieldViews = new FieldView[8][8];

    public BoardView(Occupation[][] occupations, OthelloController controller) {

	setLayout(new GridLayout(8, 8));

	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fieldViews[i][j] = new FieldView(i, j, controller);
		add(fieldViews[i][j]);
	    }
	}
    }

    public FieldView[][] getFieldViews() {
	return fieldViews;
    }

    public void updateField(int xPosition, int yPosition,
	    Occupation occupation) {

	getFieldViews()[xPosition][yPosition].setOccupation(occupation);
    }
}
