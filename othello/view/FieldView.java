package othello.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import othello.Piece;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    private static Color color = new Color(0, 128, 0);

    private final int xPosition;
    private final int yPosition;
    private Piece piece;

    public FieldView(BoardView board, int xPosition, int yPosition, Piece piece) {

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        setPiece(piece);

        setPreferredSize(new Dimension(100, 100));

        addActionListener(
                e -> board.fieldClicked(getXPosition(), getYPosition()));
    }

    private static boolean checkColor(Color color) {
        int brightness = Math.max(color.getRed(),
                Math.max(color.getGreen(), color.getBlue())) * color.getAlpha();

        if (85 * 255 < brightness && brightness < 190 * 255) {
            return true;
        }
        return false;
    }

    public static Color getColor() {
        return new Color(color.getRGB());
    }

    public static void setColor(Color color) {
        if (checkColor(color)) {
            FieldView.color = color;
        } else {
            throw new IllegalArgumentException(
                    "color too bright, too dark or too transparent");
        }
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
            setBackground(color);
        } else if (piece == Piece.DARK) {
            setBackground(Color.BLACK);
        } else {
            setBackground(Color.WHITE);
        }
    }
}
