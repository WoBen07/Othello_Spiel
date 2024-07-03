package othello.view;

import java.awt.*;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import othello.Piece;

@SuppressWarnings("serial")
public class BoardView extends JPanel {

    private OthelloGUI gui;
    private final FieldView[][] fields = new FieldView[8][8];
    private Piece[][] pieceFormation;

    public BoardView(OthelloGUI gui, Piece[][] pieceFormation) {
        initFields();
        setGUI(gui);
        setPieceFormation(pieceFormation);

        setLayout(new ProportionalLayout());
        addFields();
        setBorder(new LineBorder(new Color(139, 69, 19), 99999));
    }

    private static boolean checkPieceFormation(Piece[][] pieceFormation) {
        if (pieceFormation.length != 8) {
            return false;
        }
        for (int i = 0; i < 8; ++i) {
            if (pieceFormation[i].length != 8) {
                return false;
            }
        }
        return true;
    }

    public void setGUI(OthelloGUI gui) {
        this.gui = gui;
    }

    private void initFields() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                fields[i][j] = new FieldView(this, i, j, Piece.NONE);
            }
        }
    }

    private void updateFields() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                fields[i][j].setPiece(getPieceFormation()[i][j]);
            }
        }
    }

    private void addFields() {
        ProportionalLayout layout = (ProportionalLayout) getLayout();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                layout.addLayoutComponent(fields[i][j], i / 8.0f, j / 8.0f, 1 / 8.0f, 1 / 8.0f);
                add(fields[i][j]);
            }
        }
    }

    public Piece[][] getPieceFormation() {
        return Arrays.copyOf(pieceFormation, pieceFormation.length);
    }

    public void setPieceFormation(Piece[][] pieceFormation) {
        if (checkPieceFormation(pieceFormation)) {
            this.pieceFormation = pieceFormation;

            updateFields();
        } else {
            throw new IllegalArgumentException("pieceFormation does not include 8x8 pieces");
        }
    }

    public void fieldClicked(int xPosition, int yPosition) {
        gui.fieldClicked(xPosition, yPosition);
    }
}
