package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

import othello.Piece;

public class FieldView extends JButton {

    public static final int WIDTH = 30;
    private static final Color backgroundColor = new Color(0, 128, 0);
    private static final Color legalMoveColor = new Color(0, 0, 255);

    private final int xPosition;
    private final int yPosition;
    private Piece piece;
    private boolean isLegalMove;

    public FieldView(BoardView board, int xPosition, int yPosition, Piece piece) {

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isLegalMove = false;

        setPiece(piece);

        setMinimumSize(new Dimension(WIDTH, WIDTH));
        setMaximumSize(new Dimension(WIDTH, WIDTH));
        setPreferredSize(new Dimension(WIDTH, WIDTH));
        setFocusable(false);

        setUI(BasicButtonUI.createUI(this));

        addActionListener(_ -> board.fieldClicked(getXPosition(), getYPosition()));
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;

        if (piece == Piece.NONE && getIsLegalMove()) {
            setColor(legalMoveColor);
        } else if (piece == Piece.NONE) {
            setColor(backgroundColor);
        } else if (piece == Piece.DARK) {
            setColor(Color.BLACK);
        } else {
            setColor(Color.WHITE);
        }
    }

    public boolean getIsLegalMove() {
        return isLegalMove;
    }

    public void setLegalMove(boolean isLegalMove) {
        this.isLegalMove = isLegalMove;
        this.setColor(legalMoveColor);
    }

    /**
     * Changes the color of the entire component
     * */
    private void setColor(Color c) {
        setBackground(c);
        setForeground(c);
    }
}