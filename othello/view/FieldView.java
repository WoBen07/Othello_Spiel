package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Occupation;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    private static Color noOccupationColor = new Color(0, 128, 0);
	private static Color legalMoveColor = new Color(0, 0, 255);

    private final BoardView boardView;
    private final int xPosition;
    private final int yPosition;
    private Occupation occupation;

    public FieldView(BoardView boardView, int xPosition, int yPosition, Occupation occupation, boolean legalMove) {

	this.boardView = boardView;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	setOccupation(occupation, legalMove);

	setPreferredSize(new Dimension(100, 100));

	addActionListener(e -> getBoardView().getGUI().getController()
		.onField(getXPosition(), getYPosition()));
    }

    public BoardView getBoardView() {
	return boardView;
    }

    public int getXPosition() {
	return xPosition;
    }

    public int getYPosition() {
	return yPosition;
    }

    public Occupation getOccupation() {
	return occupation;
    }

    public void setOccupation(Occupation occupation, boolean legalMove) {
	this.occupation = occupation;

	if ((occupation == Occupation.NONE) && legalMove) {
	    setBackground(legalMoveColor);
	} else if (occupation == Occupation.NONE)
		setBackground(noOccupationColor); 
	else if (occupation == Occupation.DARK) {
	    setBackground(Color.BLACK);
	} else {
	    setBackground(Color.WHITE);
	}
    }
}
