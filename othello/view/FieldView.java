package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    private static Color color = new Color(0, 128, 0);
    private final int xPosition;
    private final int yPosition;
    private final Occupation occupation;

    public FieldView(int xPosition, int yPosition, Occupation occupation) {
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	this.occupation = occupation;

	if (occupation == Occupation.NONE) {
	    setBackground(color);
	} else if (occupation == Occupation.BLACK) {
	    setBackground(Color.BLACK);
	} else {
	    setBackground(Color.WHITE);
	}

	setPreferredSize(new Dimension(100, 100));

	addActionListener(new OthelloController());
    }

    public int getXPosition() {
	return xPosition;
    }

    public int getYPosition() {
	return yPosition;
    }
}
