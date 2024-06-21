package othello.model;

import othello.Occupation;

public class BoardModel {

    private final FieldModel[][] fields = new FieldModel[8][8];
    private Occupation[][] fieldOccupations;
    private boolean isBlacksTurn = true;

    public BoardModel(Occupation[][] fieldOccupations) {
	setFieldOccupations(fieldOccupations);
	setFields();
    }

    private static boolean checkFieldOccupations(
	    Occupation[][] fieldOccupations) {

	if (fieldOccupations.length != 8) {
	    return false;
	}
	for (int i = 0; i < 8; ++i) {
	    if (fieldOccupations[i].length != 8) {
		return false;
	    }
	}
	return true;
    }

    public FieldModel[][] getFields() {
	return fields;
    }

    private void setFields() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		getFields()[i][j] = new FieldModel(getFieldOccupations()[i][j]);
	    }
	}
    }

    public Occupation[][] getFieldOccupations() {
	return fieldOccupations;
    }

    public void setFieldOccupations(Occupation[][] fieldOccupations) {
	if (checkFieldOccupations(fieldOccupations)) {
	    this.fieldOccupations = fieldOccupations;
	} else {
	    // TODO eigene Exception implementieren
	    throw new IllegalArgumentException("64 occupation-details needed");
	}
    }

    public boolean isBlacksTurn() {
	return isBlacksTurn;
    }

    public void switchTurns() {
	if (isBlacksTurn) {
	    isBlacksTurn = false;
	} else {
	    isBlacksTurn = true;
	}
    }

    public void updateField(int xPosition, int yPosition,
	    Occupation occupation) {

	getFields()[xPosition][yPosition].setOccupation(occupation);
    }
}
