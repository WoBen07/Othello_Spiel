package othello.model;

import othello.Occupation;

public class BoardModel {

    private final FieldModel[][] fields = new FieldModel[8][8];
    private boolean isBlacksTurn = true;

    public BoardModel() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fields[i][j] = new FieldModel(i, j);
	    }
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

    public void updateOccupation(int xPosition, int yPosition) {
	if (isBlacksTurn()) {
	    fields[xPosition][yPosition].setOccupation(Occupation.BLACK);
	} else {
	    fields[xPosition][yPosition].setOccupation(Occupation.WHITE);
	}
    }
}
