package othello.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import othello.Piece;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame implements PropertyChangeListener {

    private OthelloController controller;
    private BoardView board;

    public OthelloGUI(OthelloController controller) {
	super("Othello");

	setController(controller);
	controller.getModel().addPropertyChangeListener(this);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setVisible(true);
    }
    
    public OthelloGUI(OthelloController controller, BoardView board) {
	this(controller);
	setBoard(board);
    }

    public OthelloController getController() {
	return controller;
    }

    public void setController(OthelloController controller) {
	this.controller = controller;
    }

    public BoardView getBoard() {
	return board;
    }

    public void setBoard(BoardView board) {
	this.board = board;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	if (evt.getPropertyName().equalsIgnoreCase("pieceFormation")) {
	    board.setPieceFormation((Piece[][])evt.getNewValue());
	}
    }
}
