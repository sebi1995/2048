import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        board.printBoard();
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while (true){
            board.move(scanner.next());
            board.printBoard();
            System.out.println();
        }
    }
}