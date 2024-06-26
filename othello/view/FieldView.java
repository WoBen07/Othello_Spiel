package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Piece;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    private static Color backgroundColor = new Color(0, 128, 0);

    private final BoardView boardView;
    private final int xPosition;
    private final int yPosition;
    private Piece piece;

    public FieldView(BoardView boardView, int xPosition, int yPosition,
	    Piece piece) {

	this.boardView = boardView;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	setPiece(piece);

	setPreferredSize(new Dimension(100, 100));

	addActionListener(e -> getBoardView().getGUI().getController()
		.fieldClicked(getXPosition(), getYPosition()));
    }

    public BoardView getBoardView() {
	return boardView;
    }

    public int getXPosition() {
	return xPosition;
    }

    public int getYPosition() {
	return yPosition;
    }

    public Piece getPiece() {
	return piece;
    }

    public void setPiece(Piece piece) {
	this.piece = piece;

	if (piece == Piece.NONE) {
	    setBackground(backgroundColor);
	} else if (piece == Piece.DARK) {
	    setBackground(Color.BLACK);
	} else {
	    setBackground(Color.WHITE);
	}
    }
}
