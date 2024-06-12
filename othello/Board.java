package othello;

import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel {

    private final Field[][] fields = new Field[8][8];
    private boolean isBlacksTurn = true;

    public Board() {
	super();

	// fields wird initialisiert
	for (int i = 0; i < 8; ++i) {
	    for (int j = 0; j < 8; ++j) {
		fields[i][j] = new Field();
	    }
	}

	// Startaufstellung
	fields[3][3].setOccupation(WHITE);
	fields[3][4].setOccupation(BLACK);
	fields[4][3].setOccupation(BLACK);
	fields[4][4].setOccupation(WHITE);

	// Implementierung für das Klicken auf Felder
	for (Field[] innerArray : fields) {
	    for (Field f : innerArray) {
		f.addActionListener((ActionEvent e) -> {
		    if (!f.isSelected()) {
			deselectAll();
			f.select();
			// TODO Visueller Effekt (z.B. Farbe ändern)
		    } else {
			onSelected();
			deselectAll();
		    }
		});
	    }
	}
    }

    // deselected alle Spielfelder
    private void deselectAll() {
	for (Field[] innerArray : fields) {
	    for (Field f : innerArray) {
		f.deselect();
	    }
	}
    }

    private ArrayList<int[]> getLegalMoves() {
	// TODO Es soll eine ArrayList mit int-Arrays der Größe 2 zurückgegeben
	// werden, die die Koordinaten der wählbaren Felder darstellen
    }

    private void onSelected() {
	// TODO Implementierung wie in Issue beschrieben
    }
}
