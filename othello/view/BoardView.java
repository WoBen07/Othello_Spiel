package othello.view;

import java.awt.GridLayout;

import java.util.Arrays;

import javax.swing.JPanel;

import othello.Piece;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private OthelloGUI gui;
    private final FieldView[][] fieldViews = new FieldView[8][8];
    private Piece[][] pieceFormation;

    public BoardView(OthelloGUI gui, Piece[][] pieceFormation) {
	initFieldViews();
	setGUI(gui);
	setPieceFormation(pieceFormation);

	setLayout(new GridLayout(8, 8));
	addFieldViews();

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

    private void initFieldViews() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fieldViews[i][j] = new FieldView(this, i, j, Piece.NONE);
	    }
	}
    }

    private void updateFieldViews() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fieldViews[i][j].setPiece(getPieceFormation()[i][j]);
	    }
	}
    }

    private void addFieldViews() {
	Arrays.stream(fieldViews).forEach((FieldView[] row) -> {
	    Arrays.stream(row).forEach(field -> add(field));
	});
    }

    public Piece[][] getPieceFormation() {
	return Arrays.copyOf(pieceFormation, pieceFormation.length);
    }

    public void setPieceFormation(Piece[][] pieceFormation) {
	if (checkPieceFormation(pieceFormation)) {
	    this.pieceFormation = pieceFormation;

	    updateFieldViews();
	} else {
	    throw new IllegalArgumentException(
		    "pieceFormation does not include 8x8 pieces");
	}
    }

    public void fieldClicked(int xPosition, int yPosition) {
	gui.fieldClicked(xPosition, yPosition);
    }
}
