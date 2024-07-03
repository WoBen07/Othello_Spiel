package othello.view;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import othello.Piece;
import othello.controller.OthelloController;

@SuppressWarnings("serial")
public class OthelloGUI extends JFrame implements PropertyChangeListener {

	private OthelloController controller;
	private BoardView board;
	private ProportionalLayout layout;

	public OthelloGUI(OthelloController controller) {
		super("Othello");

		setController(controller);

		layout = new ProportionalLayout();
		setLayout(layout);

		setDefaultCloseOperation(EXIT_ON_CLOSE);


		setSize(800,800);
		setResizable(false);
		setVisible(true);
	}

	public void setController(OthelloController controller) {
		this.controller = controller;
	}

	public void setBoard(BoardView board) {
		this.board = board;
	}

	public void showBoard() {
		getContentPane().removeAll();

		layout.addLayoutComponent(board, 0f, 0f, 1f, 1f);
		board.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 50));
		add(board);

		revalidate();
		repaint();
	}

	public void fieldClicked(int xPosition, int yPosition) {
		controller.fieldClicked(xPosition, yPosition);
	}

	public void showGameResult(int darkScore, int lightScore) {
		String message = "Game Over!\n" +
				"Dark: " + darkScore + "\n" +
				"Light: " + lightScore + "\n" +
				"Winner: " + (darkScore > lightScore ? "Dark" : "Light");

		String[] options = {"Close Game", "Restart Game"};
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


			dispose();

			new OthelloController();
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
		if (evt.getPropertyName().equals("gameResult")) {int[] scores = (int[]) evt.getNewValue();
			showGameResult(scores[0], scores[1]);
		}
	}

}
