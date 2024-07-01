package othello.view;

import java.awt.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;

import javax.swing.JFrame;

import othello.Piece;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame implements PropertyChangeListener {

    private OthelloController controller;
    private ArrayList<Component> components = new ArrayList<>();
    private BoardView board;

    public OthelloGUI(OthelloController controller) {
	super("Othello");

	setController(controller);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setVisible(true);
    }

    public void setController(OthelloController controller) {
	this.controller = controller;
    }

    public void setBoard(BoardView board) {
	this.board = board;
    }

    public void showBoard() {
	components.forEach(c -> remove(c));

	add(board);
	components.add(board);

	pack();
    }

    public void fieldClicked(int xPosition, int yPosition) {
	controller.fieldClicked(xPosition, yPosition);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	if (evt.getPropertyName().equals("pieceFormation")) {
	    board.setPieceFormation((Piece[][])evt.getNewValue());
	}
    }
}
