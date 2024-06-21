package othello.view;

import java.awt.GridLayout;

import java.util.Arrays;

import javax.swing.JPanel;

import othello.Occupation;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private OthelloGUI gui;
    private final FieldView[][] fieldViews = new FieldView[8][8];
    private Occupation[][] fieldViewOccupations;

    public BoardView(OthelloGUI gui, Occupation[][] fieldViewOccupations) {

	setGUI(gui);
	setFieldViewOccupations(fieldViewOccupations);

	setLayout(new GridLayout(8, 8));

	setFieldViews();
	addFieldViews();
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

    public OthelloGUI getGUI() {
	return gui;
    }

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
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

    private void addFieldViews() {
	Arrays.stream(getFieldViews()).forEach((FieldView[] row) -> {
	    Arrays.stream(row).forEach(col -> add(col));
	});
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

    public void updateFieldView(int xPosition, int yPosition,
	    Occupation occupation) {

	getFieldViews()[xPosition][yPosition].setOccupation(occupation);
    }
}
