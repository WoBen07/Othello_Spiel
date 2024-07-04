package othello.view;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;

import javax.swing.*;

import othello.Piece;
import othello.controller.OthelloController;


/**
 * This class represents the game window
 * */
public class OthelloGUI extends JFrame implements PropertyChangeListener {

    private OthelloController controller;
    private ArrayList<Component> components = new ArrayList<>();
    private BoardView board;
    private boolean easyMode;

    public OthelloGUI(OthelloController controller) {
        super("Othello");

        setController(controller);

        showHome();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 720);
        setVisible(true);
    }

    public void setController(OthelloController controller) {
        this.controller = controller;
    }

    public void setBoard(BoardView board) {
        this.board = board;
    }

    private void clearFrame() {
        components.forEach(this::remove);
        components.clear();
    }

    public void showHome() {
        clearFrame();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.weightx = 1;

        JButton newButton = new JButton("New Game");
        newButton.setPreferredSize(new Dimension(200, 40));
        newButton.addActionListener(e -> {
            panel.removeAll();
            controller.newGame();
        });
        panel.add(newButton, gbc);

        JButton loadButton = new JButton("Load Game");
        loadButton.setPreferredSize(new Dimension(200, 40));
        // TODO: Add appropriate action listener for loading game
        panel.add(loadButton, gbc);

        JButton rulesButton = new JButton("Show Rules");
        rulesButton.setPreferredSize(new Dimension(200, 40));
        rulesButton.addActionListener(e -> showRules());
        panel.add(rulesButton, gbc);

        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(200, 40));
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton, gbc);

        add(panel, BorderLayout.CENTER);
        components.add(panel);

        //setLocationRelativeTo(null);
        setVisible(true);
    }


    private void showRules() {
        JOptionPane.showMessageDialog(this,
                "Othello Spielregeln:\n" +
                        "1. Das Spiel wird auf einem 8x8 Brett gespielt.\n" +
                        "2. Die Spieler setzen abwechselnd Steine auf das Brett.\n" +
                        "3. Steine werden durch Einklammern der gegnerischen Steine erobert.\n" +
                        "4. Das Spiel endet, wenn kein Spieler mehr einen gültigen Zug machen kann.\n" +
                        "5. Der Spieler mit den meisten Steinen auf dem Brett gewinnt.",
                "Spielregeln",
                JOptionPane.INFORMATION_MESSAGE);
    }


    public void showBoard() {
        clearFrame();

        add(board, BorderLayout.CENTER);
        components.add(board);

        JButton homeButton = new JButton("Back to Home");
        homeButton.addActionListener(e -> controller.backHome());
        add(homeButton, BorderLayout.SOUTH);
        components.add(homeButton);

        setVisible(true);
    }

    public void fieldClicked(int xPosition, int yPosition) {
        controller.fieldClicked(xPosition, yPosition);
    }


    public void showEndScreen(int darkScore, int lightScore) {
        String message = "Game Over!\n" +
                "Dark: " + darkScore + "\n" +
                "Light: " + lightScore + "\n" +
                "Winner: " + (darkScore > lightScore ? "Dark" : "Light");

        String[] options = {"Close Game", "Back to Home"};
        int choice = JOptionPane.showOptionDialog(this,
                message,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (choice == JOptionPane.NO_OPTION) {
            showHome();
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("pieceFormation")) {
            board.setPieceFormation((Piece[][]) evt.getNewValue());
        }
        if (evt.getPropertyName().equals("passPlayed") && (boolean) evt.getNewValue() == true) {
            JOptionPane.showMessageDialog(this, "No legal moves, you have to pass");
        }
        if (evt.getPropertyName().equals("gameResult")) {
            int[] scores = (int[]) evt.getNewValue();
            showEndScreen(scores[0], scores[1]);
        }
    }

    public OthelloController getController() {
        return controller;
    }
}