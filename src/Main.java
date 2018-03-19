import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(4);
        Scanner scanner = new Scanner(System.in);

        System.out.println(board.getBoard());

        while (board.gameIsNotOver()) {
            board.move(scanner.next());
            System.out.println(board.getBoard());
            System.out.println();
        }

        System.out.println("Your final score is: " + board.getScore());
    }
}