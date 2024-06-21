package othello;

public enum Occupation {
    NONE, BLACK, WHITE;
    
    public static void fill(Occupation[][] a, Occupation val) {
	for (int i = 0; i < a.length; ++i) {
	    for (int j = 0; j < a[i].length; ++j) {
		a[i][j] = val;
	    }
	}
    }

    public static Occupation[][] startOccupations() {
	Occupation[][] startOccupations = new Occupation[8][8];
	fill(startOccupations, NONE);
	startOccupations[3][3] = WHITE;
	startOccupations[3][4] = BLACK;
	startOccupations[4][3] = BLACK;
	startOccupations[4][4] = WHITE;
	return startOccupations;
    }
}
