import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Parjees game = new Parjees(input);
        game.playGame();
        input.close();
    }
}
