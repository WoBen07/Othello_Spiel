package othello.view;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

import othello.Piece;


public class BoardView extends JPanel {

    private OthelloGUI gui;
    private final FieldView[][] fields = new FieldView[8][8];
    private Piece[][] pieceFormation;
    private final JPanel gameBoard;


    public BoardView(OthelloGUI gui, Piece[][] pieceFormation) {
        setLayout(new BorderLayout());

        setBackground(new Color(139, 69, 19));
        gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(8, 8, 3, 3));
        gameBoard.setBackground(getBackground());
        add(gameBoard, BorderLayout.CENTER);
        addBorders();

        initFields();
        setGUI(gui);
        setPieceFormation(pieceFormation);

        //setLayout(new ProportionalLayout());
        addFields();
        //setBorder(new LineBorder(new Color(139, 69, 19), 99999));
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
        boolean[][] legalMoves = gui.getController().getModel().getLegalMoves();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                fields[i][j].setLegalMove(legalMoves[i][j]);
                fields[i][j].setPiece(getPieceFormation()[i][j]);

            }
        }
    }

    private void addFields() {
        //ProportionalLayout layout = (ProportionalLayout) this.getLayout();
        for (int y = 0; y < 8; ++y) {
            for (int x = 0; x < 8; ++x) {
                //layout.addLayoutComponent(fields[x][y], x / 8.0f, y / 8.0f, 1 / 8.0f, 1 / 8.0f);
                gameBoard.add(fields[x][y]);
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

    private void addBorders() {
        Component[] borders = {
                Box.createVerticalStrut(100),
                Box.createHorizontalStrut(100),
                Box.createVerticalStrut(100),
                Box.createHorizontalStrut(100),
        };

        for (Component c : borders) {
            c.setBackground(getBackground());
        }

        Object[] positions = {
                BorderLayout.NORTH,
                BorderLayout.EAST,
                BorderLayout.SOUTH,
                BorderLayout.WEST
        };

        for (int i = 0; i < 4; i++) {
            add(borders[i], positions[i]);
        }
    }
}
