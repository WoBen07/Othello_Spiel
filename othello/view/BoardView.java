package othello.view;

import java.awt.GridLayout;

import java.util.Arrays;

import javax.swing.JPanel;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private final FieldView[][] fieldViews = new FieldView[8][8];
    private Occupation[][] fieldViewOccupations;
    private OthelloController controller;

    public BoardView(Occupation[][] fieldViewOccupations,
	    OthelloController controller) {

	setFieldViewOccupations(fieldViewOccupations);
	setController(controller);

	setLayout(new GridLayout(8, 8));

	setFieldViews();

	Arrays.stream(getFieldViews()).forEach((FieldView[] row) -> {
	    Arrays.stream(row).forEach(col -> add(col));
	});
    }

    private static boolean checkFieldViewOccupations(
	    Occupation[][] fieldViewOccupations) {

	if (fieldViewOccupations.length != 8) {
	    return false;
	}
	for (int i = 0; i < 8; ++i) {
	    if (fieldViewOccupations[i].length != 8) {
		return false;
	    }
	}
	return true;
    }

    public FieldView[][] getFieldViews() {
	return fieldViews;
    }

    public void setFieldViews() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fieldViews[i][j] = new FieldView(this, i, j,
			getFieldViewOccupations()[i][j]);
	    }
	}
    }

    public Occupation[][] getFieldViewOccupations() {
	return fieldViewOccupations;
    }

    public void setFieldViewOccupations(Occupation[][] fieldViewOccupations) {
	if (checkFieldViewOccupations(fieldViewOccupations)) {
	    this.fieldViewOccupations = fieldViewOccupations;
	} else {
	    // TODO eigene Exception implementieren
	    throw new IllegalArgumentException("64 occupation-details needed");
	}
    }

    public OthelloController getController() {
	return controller;
    }

    public void setController(OthelloController controller) {
	this.controller = controller;
    }

    public void updateFieldView(int xPosition, int yPosition,
	    Occupation occupation) {

	getFieldViews()[xPosition][yPosition].updateFV(occupation);
    }
}
