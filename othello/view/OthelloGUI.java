package othello.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;

import javax.swing.*;

import othello.Piece;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame implements PropertyChangeListener {

    private OthelloController controller;
    private ArrayList<Component> components = new ArrayList<>();
    private BoardView board;
    private boolean easyMode;

    public OthelloGUI(OthelloController controller) {
	super("Othello");

	setController(controller);

	showTitleScreen();

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1280, 720);
	setVisible(true);
    }

    public void setController(OthelloController controller) {
	this.controller = controller;
    }

    public void setBoard(BoardView board) {
	this.board = board;
    }

    private void clearFrame() {
	components.forEach(c -> remove(c));
	components.clear();
    }

    public void showTitleScreen() {
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

	JCheckBox easyModeCheckBox = new JCheckBox("Easy Mode");
	easyModeCheckBox.setPreferredSize(new Dimension(200, 40));
	easyModeCheckBox.addActionListener(e -> changeEasyMode());
	panel.add(easyModeCheckBox, gbc);

	add(panel, BorderLayout.CENTER);
	components.add(panel);

	setVisible(true);
    }

    private void changeEasyMode() {
	if (this.easyMode) {
	    this.easyMode = false;
	} else if (!(this.easyMode)) {
	    this.easyMode = true;
	}
    }

    private void showRules() {
	JOptionPane.showMessageDialog(this, "Othello Spielregeln:\n"
		+ "1. Das Spiel wird auf einem 8x8 Brett gespielt.\n"
		+ "2. Die Spieler setzen abwechselnd Steine auf das Brett.\n"
		+ "3. Steine werden durch Einklammern der gegnerischen Steine erobert.\n"
		+ "4. Das Spiel endet, wenn kein Spieler mehr einen gültigen Zug machen kann.\n"
		+ "5. Der Spieler mit den meisten Steinen auf dem Brett gewinnt.",
		"Spielregeln", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showBoard() {
	clearFrame();

	add(board, BorderLayout.CENTER);
	components.add(board);

	JButton backToTitleButton = new JButton("Save and Quit to Title");
	backToTitleButton.addActionListener(e -> showTitleScreen());
	add(backToTitleButton, BorderLayout.SOUTH);
	components.add(backToTitleButton);

	setVisible(true);
    }

    public void fieldClicked(int xPosition, int yPosition) {
	controller.fieldClicked(xPosition, yPosition);
    }

    public void showGameResult() {
	int darkPieces = 0;
	int lightPieces = 0;
	int emptyFields = 0;

	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		if (board.getPieceFormation()[i][j].equals(Piece.DARK)) {
		    ++darkPieces;
		} else if (board.getPieceFormation()[i][j]
			.equals(Piece.LIGHT)) {
		    ++lightPieces;
		} else {
		    ++emptyFields;
		}
	    }
	}

	int score = Math.abs(darkPieces - lightPieces) + emptyFields;

	String message = new String();
	if (darkPieces != lightPieces) {
	    message = (darkPieces > lightPieces ? "Dark wins!\n"
		    : "Light wins!\n") + "Score: " + score;
	} else {
	    message = "Tie!\n";
	}

	String[] options = { "Save Game", "Quit without Saving" };

	int choice = JOptionPane.showOptionDialog(this, message, "Game Over!",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		null, options, options[0]);

	if (choice == 0) {
	    showTitleScreen(); // TODO Spiel speichern
	} else if (choice == 1) {
	    showTitleScreen();
	}
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
	    showGameResult();
	}
    }
}
