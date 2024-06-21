package othello.model;

import othello.Occupation;

public class BoardModel {

    private final FieldModel[][] fields = new FieldModel[8][8];
    private Occupation[][] fieldOccupations;
    private boolean darksTurn = true;
    private boolean passPlayed = false;

    public BoardModel(Occupation[][] fieldOccupations) {
	setFields();
	
	setFieldOccupations(fieldOccupations);
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
		fields[i][j] = new FieldModel(Occupation.NONE);
	    }
	}
    }

    private void updateFields() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		getFields()[i][j].setOccupation(getFieldOccupations()[i][j]);
	    }
	}
    }

    public Occupation[][] getFieldOccupations() {
	return fieldOccupations;
    }

    public void setFieldOccupations(Occupation[][] fieldOccupations) {
	if (checkFieldOccupations(fieldOccupations)) {
	    this.fieldOccupations = fieldOccupations;
	    updateFields();
	} else {
	    throw new IllegalArgumentException("64 occupation-details needed");
	}
    }

    public void updateFieldOccupation(int xPosition, int yPosition,
	    Occupation occupation) {
	getFieldOccupations()[xPosition][yPosition] = occupation;
	updateFields();
    }

    public boolean isDarksTurn() {
	return darksTurn;
    }

    public void switchTurns() {
	if (darksTurn) {
	    darksTurn = false;
	} else {
	    darksTurn = true;
	}
    }

    public boolean wasPassPlayed() {
	return passPlayed;
    }

    public void setPassPlayed(boolean passPlayed) {
	this.passPlayed = passPlayed;
    }

    // TODO abhängig von isBlacksTurn für jedes Feld speichern, ob der Spieler
    // am Zug einen Stein darauf setzen darf
    public boolean[][] getLegalMoves() {
	boolean[][] legalMoves = new boolean[8][8];
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		legalMoves[i][j] = true;
	    }
	}
	return legalMoves;
    }

    public boolean isLegalMove() {
	for (boolean[] row : getLegalMoves()) {
	    for (boolean b : row) {
		if (b) {
		    return true;
		}
	    }
	}
	return false;
    }

    // TODO hier sollen die Steine, die mit dem gerade gesetzten Stein
    // eingeschlossen wurden, (mithilfe von updateField()) "umgedreht" werden
    public void flipOccupations(int xNewPiece, int yNewPiece) {

    }
}
