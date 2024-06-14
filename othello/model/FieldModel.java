package othello.model;

import othello.Occupation;

public class FieldModel {

    private final int xPosition;
    private final int yPosition;
    private Occupation occupation = Occupation.NONE;

    public FieldModel(int xPosition, int yPosition) {
	this.xPosition = xPosition;
	this.yPosition = yPosition;
    }

    public void setOccupation(Occupation occupation) {
	this.occupation = occupation;
    }
}
