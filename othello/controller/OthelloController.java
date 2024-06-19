package othello.controller;

import othello.Occupation;
import othello.model.BoardModel;
import othello.view.OthelloGUI;

public class OthelloController {

    private OthelloGUI gui;
    private BoardModel model;

    public OthelloGUI getGUI() {
	return gui;
    }

    public void setGUI(OthelloGUI gui) {
	this.gui = gui;
    }

    public BoardModel getModel() {
	return model;
    }

    public void setModel(BoardModel model) {
	this.model = model;
    }

    public void onField(int xPosition, int yPosition) {
	if (getModel().isBlacksTurn()) {
	    updateFieldModel(xPosition, yPosition, Occupation.BLACK);
	    updateFieldView(xPosition, yPosition, Occupation.BLACK);
	    getModel().switchTurns();
	} else {
	    updateFieldModel(xPosition, yPosition, Occupation.WHITE);
	    updateFieldView(xPosition, yPosition, Occupation.WHITE);
	    getModel().switchTurns();
	}
    }

    public void updateFieldModel(int xPosition, int yPosition,
	    Occupation occupation) {

	getModel().updateField(xPosition, yPosition, occupation);
    }

    public void updateFieldView(int xPosition, int yPosition,
	    Occupation occupation) {

	getGUI().getBoard().updateField(xPosition, yPosition, occupation);
    }
}
