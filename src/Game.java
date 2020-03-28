import java.util.HashMap;

public class Game {
    private Map mapGame;
    private Player player;

    public Game(Map mapGame, Player player) {
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

}
