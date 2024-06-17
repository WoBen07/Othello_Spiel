package othello.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.Occupation;
import othello.view.BoardView;
import othello.view.OthelloGUI;

public class OthelloController implements ActionListener {
    
    public static void updateGUI(OthelloGUI gui, Occupation[][] fieldOccupations) {
	gui.add(new BoardView(fieldOccupations));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	
    }

}
