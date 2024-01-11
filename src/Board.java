import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;

    public Board() {
        this.squares = new ArrayList<Square>(84);
        for (int i = 0; i < 84; i++) {
            squares.add(new Square());
        }
        squares.get(10).setSafeZone(true);
        squares.get(21).setSafeZone(true);
        squares.get(27).setSafeZone(true);
        squares.get(38).setSafeZone(true);
        squares.get(44).setSafeZone(true);
        squares.get(55).setSafeZone(true);
        squares.get(61).setSafeZone(true);
        squares.get(72).setSafeZone(true);
    }

    public Square getSquare(int index) {
        return squares.get(index);
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

}
