package othello.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Arrays;
import othello.Piece;

@SuppressWarnings("serial")
public class BoardModel implements Serializable {

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private final FieldModel[][] fields = new FieldModel[8][8];
    private Piece[][] pieceFormation;
    private boolean darksTurn = true;
    private boolean[][] legalMoves;
    private boolean hasLegalMove = false;
    private boolean passPlayed = false;
    private boolean running = true;

    public BoardModel() {
	initFields();
	setPieceFormation(Piece.startFormation());
    }

    public BoardModel(Piece[][] pieceFormation, boolean darksTurn,
	    boolean passPlayed, boolean running) {
	initFields();
	setPieceFormation(pieceFormation);
	this.darksTurn = darksTurn;
	setPassPlayed(passPlayed);
	this.running = running;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
	changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
	changes.removePropertyChangeListener(l);
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
		fields[i][j].setPiece(getPieceFormation()[i][j]);
	    }
	}
    }

    public Piece[][] getPieceFormation() {
	return Arrays.copyOf(pieceFormation, pieceFormation.length);
    }

    public void setPieceFormation(Piece[][] pieceFormation) {
	if (checkPieceFormation(pieceFormation)) {
	    this.pieceFormation = pieceFormation;

	    updateFields();
	    updateLegalMoves();
	    changes.firePropertyChange("pieceFormation", null, pieceFormation);
	} else {
	    throw new IllegalArgumentException(
		    "pieceFormation does not include 8x8 pieces");
	}
    }

    public void updatePieceFormation(int xPosition, int yPosition,
	    Piece newPiece) {

	pieceFormation[xPosition][yPosition] = newPiece;

	updateFields();
	updateLegalMoves();
	changes.firePropertyChange("pieceFormation", null, getPieceFormation());
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

	updateLegalMoves();
    }

    private boolean checkMove(int xNewPiece, int yNewPiece,
	    boolean flipPieces) {

	int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
		{ -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

	for (int[] direction : directions) {
	    if (xNewPiece + direction[0] >= 0 && xNewPiece + direction[0] < 8
		    && yNewPiece + direction[1] >= 0
		    && yNewPiece + direction[1] < 8) {

		int x = xNewPiece + direction[0];
		int y = yNewPiece + direction[1];

		if (getPieceFormation()[x][y]
			.equals(isDarksTurn() ? Piece.LIGHT : Piece.DARK)) {

		    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
			if (getPieceFormation()[x][y].equals(Piece.NONE)) {
			    break;
			}
			if (getPieceFormation()[x][y]
				.equals(darksTurn ? Piece.DARK : Piece.LIGHT)) {

			    if (flipPieces) {
				int flipX = xNewPiece + direction[0];
				int flipY = yNewPiece + direction[1];

				while (!(flipX == x && flipY == y)) {
				    updatePieceFormation(flipX, flipY,
					    darksTurn ? Piece.DARK
						    : Piece.LIGHT);
				    flipX += direction[0];
				    flipY += direction[1];
				}
			    } else {
				return true;
			    }
			    break;
			}
			x += direction[0];
			y += direction[1];
		    }
		}
	    }
	}
	return false;
    }

    private boolean isLegalMove(int x, int y) {
	if (getPieceFormation()[x][y].equals(Piece.NONE)) {
	    return checkMove(x, y, false);
	}
	return false;
    }

    public boolean[][] getLegalMoves() {
	return Arrays.copyOf(legalMoves, legalMoves.length);
    }

    private void updateLegalMoves() {
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

    public boolean hasLegalMove() {
	return hasLegalMove;
    }

    public boolean wasPassPlayed() {
	return passPlayed;
    }

    public void setPassPlayed(boolean passPlayed) {
	boolean oldValue = wasPassPlayed();
	this.passPlayed = passPlayed;

	changes.firePropertyChange("passPlayed", oldValue, passPlayed);
    }

    public boolean isGameOver() {
	return !running;
    }

    public void stopGame() {
	running = false;

	changes.firePropertyChange("running", true, false);
    }

    public void flipPieces(int xNewPiece, int yNewPiece) {
	checkMove(xNewPiece, yNewPiece, true);
    }

}
