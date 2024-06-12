package othello;

import javax.swing.JButton;

public class Field extends JButton {

    private Occupation occupation = NONE;
    private boolean selected = false;

    public Field() {
	super();
    }

    public void setOccupation(Occupation occupation) {
	this.occupation = occupation;
    }
    
    public boolean isSelected() {
	return selected;
    }
    
    public void select() {
	selected = true;
    }
    
    public void deselect() {
	selected = false;
    }
}
