public class Piece {
    private Player owner;
    private int position;

    public Piece(Player owner) {
        this.owner = owner;
        this.position = -1; // -1 indicates that the piece is not on the board
    }

    public Player getOwner() {
        return owner;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
