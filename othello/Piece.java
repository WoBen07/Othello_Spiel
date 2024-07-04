package othello;

import java.util.Arrays;

public enum Piece {
    NONE, DARK, LIGHT;

    public static void fill(Piece[][] a, Piece val) {
        for (Piece[] pieces : a) {
            Arrays.fill(pieces, val);
        }
    }

    public static Piece[][] startFormation() {
        Piece[][] startFormation = new Piece[8][8];
        fill(startFormation, NONE);
        startFormation[3][3] = LIGHT;
        startFormation[3][4] = DARK;
        startFormation[4][3] = DARK;
        startFormation[4][4] = LIGHT;
        return startFormation;
    }
}
