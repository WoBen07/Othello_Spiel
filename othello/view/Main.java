package othello.view;

import othello.controller.OthelloController;
import othello.model.BoardModel;

public class Main {

    public static void main(String[] args) {
	OthelloController controller = new OthelloController();
	
	OthelloGUI gui = new OthelloGUI(controller);
	controller.setGUI(gui);
	
	BoardModel board = new BoardModel();
	controller.setModel(board);
    }
}
