import java.util.HashMap;
import java.util.Scanner;

public class Multiple {
    private Map mapGame;
    private Player player;

    public Multiple(Map mapGame, Player player) {
        this.mapGame = mapGame;
        this.player = player;
    }
    public boolean checkWinner() {
        HashMap<String, Boolean> checker = new HashMap<String, Boolean>();
        int[][] map = mapGame.getMap();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] != 0) {
                    checker = player.availableMove(map[i][j], i, j);
                    if (checker.size() != 0) {
                        return false;
                    }
                }
                checker.clear();
            }
        }
        int player1 = 0, player2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == 1) player1++;
                else if (map[i][j] == -1) player2++;
            }
        }
        if (player1 > player2) {
            System.out.println("Player 1 win :)");
            return true;
        } else if (player1 < player2) {
            System.out.println("Player 2 win :)");
            return true;
        } else {
            System.out.println("Draw :(");
            return true;
        }
    }
    public void playWithFriend(){
        int round = 1;
        int[][] map = mapGame.getMap();
        while (!checkWinner()) {
            mapGame.print();
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
        checkWinner();
    }
}
