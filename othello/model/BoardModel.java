package othello.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Arrays;

import othello.Piece;

@SuppressWarnings("serial")
public class BoardModel implements Serializable {

    private final FieldModel[][] fields = new FieldModel[8][8];
    private Piece[][] pieceFormation;
    private boolean darksTurn = true;
    private boolean passPlayed = false;
    private boolean[][] legalMoves;
    private boolean hasLegalMove = false;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public BoardModel() {
	initFields();

	setPieceFormation(Piece.startFormation());
	updateLegalMoves();
    }

    public BoardModel(Piece[][] pieceFormation) {
	initFields();

	setPieceFormation(pieceFormation);
	updateLegalMoves();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
	changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
	changes.removePropertyChangeListener(l);
    }

    public void firePropertyChange(String propertyName, Object oldValue,
	    Object newValue) {

	changes.firePropertyChange(propertyName, oldValue, newValue);
    }

    private static boolean checkPieceFormation(Piece[][] pieceFormation) {

	if (pieceFormation.length != 8) {
	    return false;
	}
	for (int i = 0; i < 8; ++i) {
	    if (pieceFormation[i].length != 8) {
		return false;
	    }
	}
	return true;
    }

    private FieldModel[][] getFields() {
	return fields;
    }

    private void initFields() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fields[i][j] = new FieldModel(Piece.NONE);
	    }
	}
    }

    private void updateFields() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		getFields()[i][j].setPiece(getPieceFormation()[i][j]);
	    }
	}
    }

    public Piece[][] getPieceFormation() {
	return Arrays.copyOf(pieceFormation, pieceFormation.length);
    }

    public void setPieceFormation(Piece[][] pieceFormation) {
	if (checkPieceFormation(pieceFormation)) {
	    Piece[][] oldValue = getPieceFormation();
	    this.pieceFormation = pieceFormation;
	    updateFields();
	    firePropertyChange("pieceFormation", oldValue, pieceFormation);
	} else {
	    throw new IllegalArgumentException(
		    "pieceFormation does not include 8x8 pieces");
	}
    }

    public void updatePieceFormation(int xPosition, int yPosition,
	    Piece newPiece) {
	getPieceFormation()[xPosition][yPosition] = newPiece;
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

    private boolean checkMove(int xNewPiece, int yNewPiece,
	    boolean flipPieces) {

	boolean atLeastOnePieceFlipped = false;

	int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, // vertikal
									 // und
									 // horizontal
		{ -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } // diagonal
	};

	// geht durch alle mglichen richtungen durch und checkt falls etwas
	// umgedreht werden muss
	for (int[] direction : directions) {
	    if (xNewPiece + direction[0] >= 0 && xNewPiece + direction[0] < 8
		    && yNewPiece + direction[1] >= 0
		    && yNewPiece + direction[1] < 8) {

		boolean opponentPieceFound = false; // true fals min. ein Stein
						    // des
						    // Gegners in die jeweilige
						    // Richtung gefunden wird
						    // (ohne
						    // Leere felder dazwischen)
		int x = xNewPiece + direction[0];
		int y = yNewPiece + direction[1];

		// OpponentPieceFound muss nur einmal true gesetzt werden, wenn
		// min. ein generischer Stein in die Richtung gefunden wird,
		// um anschliesend wenn ein eigener Stein gefunden wird, zu
		// bestaetigen dass auch min.
		// ein gegnerischer Stein dazwischen liegt
		if (getPieceFormation()[x][y] == (isDarksTurn() ? Piece.LIGHT
			: Piece.DARK)) {
		    opponentPieceFound = true;

		    // wenn der neue Platz einen eigenen Stein hat und min. ein
		    // gegnerischer Stein dazwischen liegt,
		    // dann drehe alle diese gegnerischen Steine um
		}

		// geht in die jeweilige Richtung bis ein eigener Stein gefunden
		// wird
		if (opponentPieceFound) {
		    while (x >= 0 && x < 8 && y >= 0 && y < 8) { // damit nicht
								 // außerhalb
								 // des
								 // Spielfeldes
								 // gecheckt
								 // wird

			if (getPieceFormation()[x][y] == Piece.NONE) {
			    break;
			}
			if (getPieceFormation()[x][y] == (darksTurn ? Piece.DARK
				: Piece.LIGHT)) {

			    int flipX = xNewPiece + direction[0];
			    int flipY = yNewPiece + direction[1];

			    // flip sollange die Steine bis die Koordinaten des
			    // eigenen
			    // Steines erreicht werden
			    if (flipPieces) {
				while (flipX != x || flipY != y) {
				    updatePieceFormation(flipX, flipY,
					    darksTurn ? Piece.DARK
						    : Piece.LIGHT);
				    flipX += direction[0];
				    flipY += direction[1];
				}
			    }
			    atLeastOnePieceFlipped = true;
			    break;
			}

			// geht in die jeweilige richtung weiter
			x += direction[0];
			y += direction[1];
		    }
		}
	    }

	}

	return atLeastOnePieceFlipped;
    }

    private boolean isLegalMove(int x, int y) {
	if (getPieceFormation()[x][y] == Piece.NONE) {
	    return checkMove(x, y, false);
	}
	return false;
    }

    public boolean[][] getLegalMoves() {
	return legalMoves;
    }

    // sollte moeglichst nur einmal pro zug ausgefuert werden und dann in einer
    // variable gespeichert werden
    public void updateLegalMoves() {
	hasLegalMove = false;
	boolean[][] tempLegalMoves = new boolean[8][8];
	for (int i = 0; i < 8; i++) {
	    for (int j = 0; j < 8; j++) {
		tempLegalMoves[i][j] = (isLegalMove(i, j));
		if (tempLegalMoves[i][j]) {
		    hasLegalMove = true;
		}
	    }
	}

	this.legalMoves = tempLegalMoves;
    }

    public boolean hasLegalMoves() {
	return hasLegalMove;
    }

    public void flipPieces(int xNewPiece, int yNewPiece) {
	checkMove(xNewPiece, yNewPiece, true);
    }
}
