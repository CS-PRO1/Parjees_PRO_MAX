import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String name;
    private Piece[] pieces;
    private Board track;
    private ArrayList<Integer> score;

    public ArrayList<Integer> getScore() {
        return score;
    }

    Random shells;

    public Player(String name) {
        this.name = name;
        track = new Board();
        this.pieces = new Piece[4];
        for (int i = 0; i < 4; i++) {
            this.pieces[i] = new Piece(this);
        }
        this.shells = new Random();
        this.score = new ArrayList<Integer>();
    }

    public Board getTrack() {
        return track;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void shellThrow() {
        int shellthrow = shells.nextInt(6);
        switch (shellthrow) {
            case 0:
                score.add(6);
                break;
            case 1:
                score.add(10);
                score.add(1);
                break;
            case 2:
                score.add(2);
                break;
            case 3:
                score.add(3);
                break;
            case 4:
                score.add(4);
                break;
            case 5:
                score.add(25);
                score.add(1);
                break;
            case 6:
                score.add(12);
        }
    }

    public boolean movePiece(Player player, Player otherplayer, Piece piece, int numSpaces) {
        Board track = player.getTrack();
        int currentPosition = piece.getPosition();
        int newPosition = (currentPosition + numSpaces);
        int enemyposition = 0;
        for (Piece piece2 : otherplayer.pieces) {
            if (player.name == "Player 1") {
                enemyposition = piece2.getPosition() + 44;
            } else {
                enemyposition = piece2.getPosition() - 44;
            }
            if (newPosition == enemyposition) {
                if (!otherplayer.track.getSquare(newPosition).isSafeZone()) {
                    otherplayer.track.getSquare(enemyposition).unOccupy(piece2);
                    piece2.setPosition(-1);
                    piece.setPosition(newPosition);
                    return true;
                } else
                    System.out.println("You can't make this move");
                return false;
            }
        }
        if (newPosition <= track.getSquares().size()) {
            piece.setPosition(newPosition);
            return true;
        } else {
            System.out.println("Too many steps, can't move");
            return false;
        }

    }

    public boolean hasNotStarted() {
        for (Piece piece : pieces) {
            if (piece.getPosition() != -1) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWon() {
        int counter = 0;
        for (Piece piece : pieces) {
            if (piece.getPosition() == 83) {
                counter++;
            }
        }
        if (counter == 4) {
            return true;
        }
        return false;
    }

}