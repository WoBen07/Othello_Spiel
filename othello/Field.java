package othello;

import javax.swing.JButton;
import java.awt.*;

public class Field extends JButton {


    enum Occupation {
        BLACK,
        WHITE,
        NONE
    }

    private Occupation occupation = Occupation.NONE;
    private boolean selected = false;
    private final int xCoordinate;
    private final int yCoordinate;

    public Field(int xCoordinate, int yCoordinate) {
        super();
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void setOccupation(Occupation occupation) {
	this.occupation = occupation;
    }
    
    public boolean isSelected() {
	return this.selected;
    }
    
    public void select() {
	this.selected = true;
    }
    
    public void deselect() {
	this.selected = false;
    }

    public Occupation getOccupation() {
        return this.occupation;
    }

    public String getCoordinates() {
        return this.xCoordinate + "" + this.yCoordinate;
    }

    public void changeColorForSelect() {
        this.setBackground(Color.getHSBColor(37,150,190));
    }
    public void changeColorToDefault() {
        this.setBackground(Color.WHITE);
    }
}
