package othello.view;

import java.awt.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	components.clear();

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
	if (evt.getPropertyName().equals("passPlayed")
		&& (boolean)evt.getNewValue() == true) {

	    JOptionPane.showMessageDialog(this,
		    "No legal moves, you have to pass");
	}
	if (evt.getPropertyName().equals("running")
		&& (boolean)evt.getNewValue() == false) {

	    JOptionPane.showMessageDialog(this, "Game End"); // temporär

	    // TODO Hier soll das Spielergebnis angezeigt werden
	    // Punktzahl und Gewinner sollten vom Model mit einem angepassten
	    // PropertyChangeEvent losgesendet werden, sodass diese nicht vom
	    // GUI bestimmt werden, da das GUI die Information ja nur
	    // visualisieren soll
	}
    }
}
