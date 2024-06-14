package othello.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FieldView extends JButton {

    public FieldView() {
	setPreferredSize(new Dimension(100, 100));
	setIcon(new ImageIcon("Semesteraufgabe/Othello_Spiel/othello/view/blackCircle.png"));
    }
}
