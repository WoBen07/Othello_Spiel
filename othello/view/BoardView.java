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
	private boolean[][] legalMoves;

    public BoardView(OthelloGUI gui, Occupation[][] fieldViewOccupations, boolean[][] legalMoves) {
	setLegalMoves(legalMoves);
	setFieldViews();

	setGUI(gui);
	setFieldViewOccupations(fieldViewOccupations, legalMoves);

	setLayout(new GridLayout(8, 8));

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

    private void setFieldViews() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fieldViews[i][j] = new FieldView(this, i, j, Occupation.NONE, getLegalMoves()[i][j]);
	    }
	}
    }

    private void updateFieldViews() {
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		getFieldViews()[i][j]
			.setOccupation(getFieldViewOccupations()[i][j], getLegalMoves()[i][j]);
	    }
	}
    }

	private boolean[][] getLegalMoves() {
		return legalMoves;
	}

    private void addFieldViews() {
	Arrays.stream(getFieldViews()).forEach((FieldView[] row) -> {
	    Arrays.stream(row).forEach(field -> add(field));
	});
    }

    public Occupation[][] getFieldViewOccupations() {
	return fieldViewOccupations;
    }

	private void setLegalMoves(boolean[][] legalMoves) {
		this.legalMoves = legalMoves;
	}

    public void setFieldViewOccupations(Occupation[][] fieldViewOccupations, boolean[][] legalMoves) {
	if (checkFieldViewOccupations(fieldViewOccupations)) {
	    this.fieldViewOccupations = fieldViewOccupations;
		setLegalMoves(legalMoves);
	    updateFieldViews();
	} else {
	    throw new IllegalArgumentException("64 occupation-details needed");
	}
    }
}
