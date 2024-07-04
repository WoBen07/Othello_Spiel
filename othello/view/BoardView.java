package othello.view;

import othello.Main;
import othello.Piece;
import othello.model.BoardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Arrays;


public class BoardView extends JPanel {

    private OthelloGUI gui;
    private final FieldView[][] fields = new FieldView[8][8];
    private Piece[][] pieceFormation;
    private final JPanel gameBoard;


    public BoardView(OthelloGUI gui, Piece[][] pieceFormation) {
        setLayout(null);

        setBackground(new Color(139, 69, 19));
        gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(8, 8, 3, 3));
        gameBoard.setBackground(getBackground().darker());
        add(gameBoard);
        //addBorders();
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                redoGameBoardLayout();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
                redoGameBoardLayout();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });

        initFields();
        setGUI(gui);
        setPieceFormation(pieceFormation);

        addFields();
    }

    public void redoGameBoardLayout() {
        int padding = 50;

        if (getWidth() < getHeight()) {
            gameBoard.setSize(getWidth() - padding * 2, getWidth() - padding * 2);
            gameBoard.setLocation(padding, (getHeight() - gameBoard.getWidth()) / 2);
        } else {
            gameBoard.setSize(getHeight() - padding * 2, getHeight() - padding * 2);
            gameBoard.setLocation((getWidth() - gameBoard.getHeight()) / 2, padding);
        }

        gameBoard.doLayout();
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
        BoardModel model = gui.getController().getModel();
        model.updateLegalMoves();
        boolean[][] legalMoves = model.getLegalMoves();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                fields[i][j].setLegalMove(legalMoves[i][j]);
                fields[i][j].setPiece(getPieceFormation()[i][j]);
            }
        }
    }

    private void addFields() {
        //ProportionalLayout layout = (ProportionalLayout) gameBoard.getLayout();
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
}