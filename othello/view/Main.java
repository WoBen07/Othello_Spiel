package othello.view;

import othello.controller.OthelloController;

public class Main {

    public static void main(String[] args) {
	new OthelloGUI(new OthelloController());
    }
}
