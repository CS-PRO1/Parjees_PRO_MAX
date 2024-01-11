public class Square {
    private boolean isSafeZone;
    private Piece[] pieces;

    public Square() {
        pieces = new Piece[4];
        for (Piece p : pieces) {
            p = null;
        }
        isSafeZone = false;
    }

    public boolean isSafeZone() {
        return isSafeZone;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setSafeZone(boolean isSafeZone) {
        this.isSafeZone = isSafeZone;
    }

    public void setOccupied(Piece piece) {
        this.pieces[pieces.length] = piece;
    }

    public void unOccupy(Piece piece) {
        for (Piece p : pieces) {
            if (p == piece) {
                p = null;
            }
        }
    }
    public int NumOfpieces(){
        int counter = 0;
        for (Piece piece : pieces) {
            if (piece != null) {
                counter++;
            }
        }
        return counter;
    }
}
