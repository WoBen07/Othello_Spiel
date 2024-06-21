package othello;

public enum Occupation {
    NONE, DARK, LIGHT;
    
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
	startOccupations[3][3] = LIGHT;
	startOccupations[3][4] = DARK;
	startOccupations[4][3] = DARK;
	startOccupations[4][4] = LIGHT;
	return startOccupations;
    }
}
