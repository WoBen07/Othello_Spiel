package othello.model;

import othello.Occupation;

public class BoardModel {

    private final FieldModel[][] fields = new FieldModel[8][8];
    private boolean isBlacksTurn = true;

    public BoardModel() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fields[i][j] = new FieldModel();
	    }
	}
    }

    public FieldModel[][] getFields() {
	return fields;
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
