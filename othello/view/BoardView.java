package othello.view;

import java.awt.GridLayout;

import java.util.Arrays;

import javax.swing.JPanel;

import othello.Piece;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private OthelloGUI gui;
    private final FieldView[][] fields = new FieldView[8][8];
    private Piece[][] pieceFormation;

    public BoardView(OthelloGUI gui, Piece[][] pieceFormation) {
	initFields();
	setGUI(gui);
	setPieceFormation(pieceFormation);

	setLayout(new GridLayout(8, 8));
	addFields();
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

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
    }

    private void initFields() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fields[i][j] = new FieldView(this, i, j, Piece.NONE);
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

    private void addFields() {
	Arrays.stream(fields).forEach((FieldView[] row) -> {
	    Arrays.stream(row).forEach(field -> add(field));
	});
    }

    public Piece[][] getPieceFormation() {
	return Arrays.copyOf(pieceFormation, pieceFormation.length);
    }

    public void setPieceFormation(Piece[][] pieceFormation) {
	if (checkPieceFormation(pieceFormation)) {
	    this.pieceFormation = pieceFormation;

	    updateFields();
	} else {
	    throw new IllegalArgumentException(
		    "pieceFormation does not include 8x8 pieces");
	}
    }

    public void fieldClicked(int xPosition, int yPosition) {
	gui.fieldClicked(xPosition, yPosition);
    }
}
