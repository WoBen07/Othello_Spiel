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
}
