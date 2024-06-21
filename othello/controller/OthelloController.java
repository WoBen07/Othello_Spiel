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
	getGUI().setBoard(
		new BoardView(getGUI(), getModel().getFieldOccupations()));
	getGUI().add(getGUI().getBoard());
	getGUI().pack();
    }

    public void onField(int xPosition, int yPosition) {
	if (getModel().getLegalMoves()[xPosition][yPosition]) {
	    if (getModel().isBlacksTurn()) {
		updateFieldModel(xPosition, yPosition, Occupation.BLACK);
		getModel().flipOccupations(xPosition, yPosition);
		updateFieldViews();
		getModel().switchTurns();
	    } else {
		updateFieldModel(xPosition, yPosition, Occupation.WHITE);
		getModel().flipOccupations(xPosition, yPosition);
		updateFieldViews();
		getModel().switchTurns();
	    }
	}
	// TODO Benutzerinformation, dass er einen falschen Zug auswählen wollte
    }

    public void updateFieldModel(int xPosition, int yPosition,
	    Occupation occupation) {

	getModel().updateField(xPosition, yPosition, occupation);
    }

    public void updateFieldViews() {
	getGUI().getBoard().updateFieldViews(getModel().getFieldOccupations());
    }
}
