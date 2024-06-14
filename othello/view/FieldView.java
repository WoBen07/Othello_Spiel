package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Occupation;

@SuppressWarnings("serial")
public class FieldView extends JButton {
    
    private static Color color = new Color(0, 128, 0);

    public FieldView() {
	setBackground(color);
	
	setPreferredSize(new Dimension(100, 100));
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
