package othello.model;

import othello.Occupation;

public class FieldModel {

    private Occupation occupation;

    public FieldModel(Occupation occupation) {
	setOccupation(occupation);
    }

    public Occupation getOccupation() {
	return occupation;
    }

    public void setOccupation(Occupation occupation) {
	this.occupation = occupation;
    }
}
