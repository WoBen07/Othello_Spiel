package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Occupation;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    private static Color color = new Color(0, 128, 0);
    
    private OthelloController controller;
    private final int xPosition;
    private final int yPosition;

    public FieldView(OthelloController controller, int xPosition, int yPosition) {
	this.controller = controller;
	this.xPosition = xPosition;
	this.yPosition = yPosition;

	setPreferredSize(new Dimension(100, 100));

	addActionListener(e -> controller.fieldClicked());
    }

    public int getXPosition() {
	return xPosition;
    }

    public int getYPosition() {
	return yPosition;
    }
    
    public void setOccupationView(Occupation occupation) {
	if (occupation == Occupation.NONE) {
	    setBackground(color);
	} else if (occupation == Occupation.BLACK) {
	    setBackground(Color.BLACK);
	} else {
	    setBackground(Color.WHITE);
	}
    }
}
