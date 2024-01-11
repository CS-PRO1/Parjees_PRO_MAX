import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Parjees {
    private Player[] players;
    // private Player player_1;
    // private Player player_2;
    private Board board;
    private int currentPlayerIndex;
    private Random random;
    Scanner input;
    // int alternator = 0;

    public Parjees(Scanner input) {
        this.players = new Player[2];
        this.players[0] = new Player("Player 1"); // Player 1's track
        this.players[1] = new Player("Player 2"); // Player 2's track
        // this.player_1 = new Player("Player 1");
        // this.player_2 = new Player("Player 2");
        this.board = new Board();
        this.currentPlayerIndex = 0;
        this.input = input;
    }

    public void initializeBoard() {

    }

    public void playGame() {
        int currentPlayerIndex = 0;
        initializeBoard();
        Player currentPlayer = players[currentPlayerIndex];
        while (!isGameOver()) {
            displayBoard();

            if (currentPlayer.hasNotStarted()) {
                firstThrow(currentPlayerIndex);
            }
            players[currentPlayerIndex].shellThrow();
            ShellToMove(currentPlayerIndex, players[currentPlayerIndex].getScore());
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    public void firstThrow(int currentPlayerIndex) {
        players[currentPlayerIndex].shellThrow();
        ArrayList<Integer> shells = players[currentPlayerIndex].getScore();
        for (int i = 0; i < shells.size(); i++) {
            if (shells.get(i).equals(1)) {
                players[currentPlayerIndex].getPieces()[0].setPosition(0);
                shells.remove(i);
            }
        }
        ShellToMove(currentPlayerIndex, shells);
    }

    public void ShellToMove(int currentPlayerIndex, ArrayList<Integer> shells) {
        for (int i = 0; i < shells.size(); i++) {
            boolean HadMoved = false;
            while (HadMoved) {
                System.out.println("Enter the index of the pieces");
                int id = input.nextInt();
                Piece p = players[currentPlayerIndex].getPieces()[id];
                HadMoved = players[currentPlayerIndex].movePiece(players[currentPlayerIndex],
                        players[(currentPlayerIndex + 1) % 2], p,
                        shells.get(i));
                if (HadMoved) {
                    break;
                }
            }

        }
    }

    public boolean isGameOver() {
        if (players[0].hasWon()) {
            System.out.println("Player 1 is the winner!");
            return true;
        } else if (players[1].hasWon()) {
            System.out.println("Player 2 is the winner!");
            return true;
        } else
            return false;
    }

    public void displayBoard() {
        Board player1Track = players[0].getTrack();
        Board player2Track = players[1].getTrack();

        System.out.println(repeatString("-", 100));
        System.out.println();
        for (Square square : player1Track.getSquares()) {
            if (square.isSafeZone()) {
                System.out.print("|X| ");
            }
            int n = square.NumOfpieces();
            System.out.print(repeatString("1 ", n));
            System.out.print("|_| ");
        }
        System.out.println("\n");
        System.out.println(repeatString("-", 100));

    }

    private boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    private String repeatString(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
