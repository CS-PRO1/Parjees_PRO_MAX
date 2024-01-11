import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Parjees {
    // private Player[] players;
    private Player player_1;
    private Player player_2;
    private Board board;
    private int currentPlayerIndex;
    private Random random;

    public Parjees() {
        // this.players = new Player[2];
        // this.players[0] = new Player("Player 1", new int[84]); // Player 1's track
        // this.players[1] = new Player("Player 2", new int[84]); // Player 2's track
        this.player_1 = new Player("Player 1");
        this.player_2 = new Player("Player 2");
        this.board = new Board();
        this.currentPlayerIndex = 0;
    }

    public void initializeBoard() {

    }

    public void playGame() {
        initializeBoard();
        int alternator = 0;
        Player currentplayer;
        while (!isGameOver()) {
            displayBoard();
            if (alternator == 0) {
                currentplayer = player_1;
            } else {
                currentplayer = player_2;
            }

            if (currentplayer.hasNotStarted()) {
                // ArrayList shell = currentplayer.shellThrow();

                // for (int i = 0; i < shell.size(); i++) {

                // }
            }

            alternator = (alternator + 1) % 2;
        }
    }

    public boolean isGameOver() {
        if (player_1.hasWon()) {
            System.out.println("Player 1 is the winner!");
            return true;
        } else if (player_2.hasWon()) {
            System.out.println("Player 2 is the winner!");
            return true;
        } else
            return false;
    }

    public void displayBoard() {
        Board player1Track = player_1.getTrack();
        Board player2Track = player_2.getTrack();

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
