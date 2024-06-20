package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Occupation;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    private static Color color = new Color(0, 128, 0);

    private final BoardView boardView;
    private final int xPosition;
    private final int yPosition;
    private Occupation occupation;

    public FieldView(BoardView boardView, int xPosition, int yPosition,
	    Occupation occupation) {

	this.boardView = boardView;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	setOccupation(occupation);

	setPreferredSize(new Dimension(100, 100));

	addActionListener(e -> getBoardView().getController()
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

    public void setOccupation(Occupation occupation) {
	this.occupation = occupation;
	if (occupation == Occupation.NONE) {
	    setBackground(color);
	} else if (occupation == Occupation.BLACK) {
	    setBackground(Color.BLACK);
	} else {
	    setBackground(Color.WHITE);
	}
    }
}
