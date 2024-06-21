package othello.controller;

import othello.Occupation;
import othello.model.BoardModel;
import othello.view.BoardView;
import othello.view.OthelloGUI;

public class OthelloController {

    private OthelloGUI gui;
    private BoardModel model;

    public OthelloController() {
	initModel();
	initView();
    }

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

    public void initModel() {
	setModel(new BoardModel(Occupation.startOccupations()));
    }

    public void initView() {
	setGUI(new OthelloGUI(this));
	getGUI().add(new BoardView(getGUI(), getModel().getFieldOccupations()));
	getGUI().pack();
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

	getGUI().getBoard().updateFieldView(xPosition, yPosition, occupation);
    }
}
