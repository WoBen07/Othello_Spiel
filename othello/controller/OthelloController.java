package othello.controller;

import javax.swing.JOptionPane;

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
		new BoardView(getGUI(), getModel().getFieldOccupations(), getModel().getLegalMoves()));
	getGUI().add(getGUI().getBoard());
	getGUI().pack();
    }

    public void onField(int xPosition, int yPosition) {
	// Wenn es einen legalen Zug gibt
	if (getModel().getLegalMoveExists()) {
	    // Wenn der ausgewählte Zug legal ist
	    if (getModel().getLegalMoves()[xPosition][yPosition]) {
				updateFieldModel(xPosition, yPosition, (getModel().isDarksTurn() ? Occupation.DARK : Occupation.LIGHT));
				getModel().flipOccupations(xPosition, yPosition);
				updateFieldViews();
				getModel().switchTurns();
	} else {
	    if (getModel().wasPassPlayed()) {
		JOptionPane.showMessageDialog(getGUI(), "Game End");
	    } else {
		JOptionPane.showMessageDialog(getGUI(),
			"No legal moves, you have to pass", null,
			JOptionPane.INFORMATION_MESSAGE);
		getModel().setPassPlayed(true);
		getModel().switchTurns();
	    }
	}
	}
}
	// TODO Benutzerinformation, dass er einen falschen Zug auswählen wollte

    public void updateFieldModel(int xPosition, int yPosition,
	    Occupation occupation) {

	getModel().updateFieldOccupation(xPosition, yPosition, occupation);
	getModel().updateLegalMoves();
    }

    public void updateFieldViews() {
	getGUI().getBoard()
		.setFieldViewOccupations(getModel().getFieldOccupations(), getModel().getLegalMoves());
    }
}
