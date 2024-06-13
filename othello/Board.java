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
		fields[i][j] = new Field(i, j);
	    }
	}

	// Startaufstellung
	fields[3][3].setOccupation(Field.Occupation.WHITE);
	fields[3][4].setOccupation(Field.Occupation.BLACK);
	fields[4][3].setOccupation(Field.Occupation.BLACK);
	fields[4][4].setOccupation(Field.Occupation.WHITE);

	// Implementierung für das Klicken auf Felder
	for (Field[] innerArray : fields) {
			for (Field f : innerArray) {


			f.addActionListener((ActionEvent e) -> {
				if (this.getSelectedFields().isEmpty()) {
					//ich denke deselectAll() koennte geloescht werden, auch wenn es natuerlich sicherer ist destrotz
					// jedes mal sicherzugehen, dass alle fields auch wirklich deselected sind
					deselectAll();
					f.select();
					f.changeColorForSelect();
				} else if (this.getSelectedFields().size() == 1 && f.isSelected()) {
					f.deselect();
					f.changeColorToDefault();
					deselectAll();
				} else {
					//weis nicht ob diese else bedingung ueberhaupt noch benoetigt wird oder weggelassen werden kann
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

    private ArrayList<String> getLegalMoves() {
		ArrayList<String> legalMoves = new ArrayList<>();
		for (Field[] innerArray : fields) {
			for (Field f : innerArray) {
				if (f.getOccupation() == Field.Occupation.NONE) {
					legalMoves.add(f.getCoordinates());
				}
			}
		}
		return legalMoves;
    }

	private ArrayList<String> getSelectedFields() {
		ArrayList<String> selectedFields = new ArrayList<>();
		for (Field[] innerArray : fields) {
			for (Field f : innerArray) {
				if (f.isSelected()) {
					selectedFields.add(f.getCoordinates());
				}
			}
		}
		return selectedFields;
	}

    private void onSelected() {
	// TODO Implementierung wie in Issue beschrieben
    }
}
