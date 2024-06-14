package othello.view;

import java.awt.Dimension;

import javax.swing.JButton;

import othello.Occupation;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    public FieldView() {
	setPreferredSize(new Dimension(100, 100));
    }

    public void setOccupationView(Occupation occupation) {
	if (occupation == Occupation.BLACK) {
	    
	}
    }
}
