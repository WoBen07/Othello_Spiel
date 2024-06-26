package othello.model;

import othello.Occupation;

public class BoardModel {

    private final FieldModel[][] fields = new FieldModel[8][8];
    private Occupation[][] fieldOccupations;
    private boolean darksTurn = true;
    private boolean passPlayed = false;
	private boolean[][] legalMoves;
	private boolean legalMoveExists = false;

    public BoardModel(Occupation[][] fieldOccupations) {
	setFields();
	
	setFieldOccupations(fieldOccupations);
	updateLegalMoves();
    }

	public boolean[][] getLegalMoves() {
		return legalMoves;
	}

	public boolean getLegalMoveExists() {
		return legalMoveExists;
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

    public void updateFieldOccupation(int xPosition, int yPosition, Occupation occupation) {
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


	//sollte moeglichst nur einmal pro zug ausgefuert werden und dann in einer variable gespeichert werden
    public void updateLegalMoves() {
	boolean[][] tempLegalMoves = new boolean[8][8];
	for (int i = 0; i < 8; i++) {
	    for (int j = 0; j < 8; j++) {
			tempLegalMoves[i][j] = (isValidMove(i, j) && isLegalMove(i, j));
			if (tempLegalMoves[i][j]) {
				legalMoveExists = true;
			}
	    }
	}	
		this.legalMoves = tempLegalMoves;
    }

    private boolean isValidMove(int x, int y) {
	if (getFieldOccupations()[x][y] == Occupation.NONE) {
	    return true;
	} else {
		return false;
	}
    }

	
    private boolean isLegalMove(int x, int y) {
        Occupation originalOccupation = getFieldOccupations()[x][y];
        getFieldOccupations()[x][y] = darksTurn ? Occupation.DARK : Occupation.LIGHT;
        boolean result = flipOccupations(x, y);
        getFieldOccupations()[x][y] = originalOccupation; 
        return result;
    }




	
    public boolean flipOccupations(int xNewPiece, int yNewPiece) {

		boolean atLeastOnePieceFlipped = false;

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // vertikal und horizontal
            {-1, -1}, {1, 1}, {-1, 1}, {1, -1} // diagonal
        };

		//geht durch alle mglichen richtungen durch und checkt falls etwas umgedreht werden muss
        for (int[] direction : directions) {

            boolean opponentPieceFound = false; //true fals min. ein Stein des Gegners in die jeweilige Richtung gefunden wird (ohne Leere felder dazwischen)

            int x = xNewPiece + direction[0];
            int y = yNewPiece + direction[1];

				
			//geht in die jeweilige Richtung bis ein eigener Stein gefunden wird
            while (x >= 0 && x < 8 && y >= 0 && y < 8) { //damit nicht außerhalb des Spielfeldes gecheckt wird

                if (getFieldOccupations()[x][y] == Occupation.NONE) { 
                    break;
                }


				//OpponentPieceFound muss nur einmal true gesetzt werden, wenn min. ein generischer Stein in die Richtung gefunden wird,
				//um anschliesend wenn ein eigener Stein gefunden wird, zu bestaetigen dass auch min. 
				//ein gegnerischer Stein dazwischen liegt
                if (getFieldOccupations()[x][y] == (darksTurn ? Occupation.LIGHT : Occupation.DARK)) {
                    opponentPieceFound = true; 
					

					//wenn der neue Platz einen eigenen Stein hat und min. ein gegnerischer Stein dazwischen liegt, 
					//dann drehe alle diese gegnerischen Steine um
                } else if (getFieldOccupations()[x][y] == (darksTurn ? Occupation.DARK : Occupation.LIGHT) && opponentPieceFound) { 
					
                    int flipX = xNewPiece + direction[0];
                    int flipY = yNewPiece + direction[1];

					//flip sollange die Steine bis die Koordinaten des eigenen Steines erreicht werden
                    while (flipX != x || flipY != y) {
                        updateFieldOccupation(flipX, flipY, darksTurn ? Occupation.DARK : Occupation.LIGHT);
                        flipX += direction[0];
                        flipY += direction[1];
                    }
					atLeastOnePieceFlipped = true;
                    break;
                } 
				
				//geht in die jeweilige richtung weiter 
                x += direction[0];
                y += direction[1];
            }
        }

	return atLeastOnePieceFlipped;
	
    }
}

