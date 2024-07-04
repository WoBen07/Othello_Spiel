package othello.model;

import othello.Piece;

public class FieldModel {

    private Piece piece;

    public FieldModel(Piece piece) {
        setPiece(piece);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
