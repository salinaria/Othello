import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player(map);
        Game game = new Game(map, player);
        map.start();
        int round = 1;
        while (!game.checkWinner()) {
            map.print();
            if (round % 2 == 1) {
                System.out.print("Player 1 round: ");
                Scanner scanner = new Scanner(System.in);
                int row = scanner.nextInt();
                String str = scanner.next();
                int column = str.charAt(0) - 'A';
                player.move(1, row - 1, column);
            }
            if (round % 2 == 0) {
                System.out.print("Player 2 round: ");
                Scanner scanner = new Scanner(System.in);
                int row = scanner.nextInt();
                String str = scanner.next();
                int column = str.charAt(0) - 'A';
                player.move(-1, row - 1, column);
            }
            round++;
        }
        game.checkWinner();
    }
}
