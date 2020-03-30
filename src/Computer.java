import java.util.ArrayList;

public class Computer {
    private Table table;
    private Player player;

    public Computer(Table table, Player player) {
        this.table = table;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Integer> availableMoves() {
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (player.moves(i, j).size() > 0) {
                    moves.add(i);
                    moves.add(j);
                }
            }
        }
        return moves;
    }

    public void chooseMove() {
        ArrayList<Integer> moves = availableMoves();
        int row = 10;
        int column = 10;
        boolean flag = false;
        int maxChange = 0;
        for (int i = 0; i < moves.size(); i = i + 2) {
            if ((moves.get(i) == 0 && moves.get(i + 1) == 0) || (moves.get(i) == 0 && moves.get(i + 1) == 7) || (moves.get(i) == 7 && moves.get(i + 1) == 0) || (moves.get(i) == 7 && moves.get(i + 1) == 7)) {
                System.out.println("Computer turn: "+(moves.get(i)+1)+" "+(char)('A'+moves.get(i+1)));
                player.applyMove(moves.get(i), moves.get(i + 1));
                flag = true;
                break;
            } else if ((moves.get(i) == 0 && moves.get(i + 1) == 2) || (moves.get(i) == 0 && moves.get(i + 1) == 5) || (moves.get(i) == 7 && moves.get(i + 1) == 2) || (moves.get(i) == 7 && moves.get(i + 1) == 5)) {
                System.out.println("Computer turn: "+(moves.get(i)+1)+" "+(char)('A'+moves.get(i+1)));
                player.applyMove(moves.get(i), moves.get(i + 1));
                flag = true;
                break;
            } else {
                if (player.moves(moves.get(i), moves.get(i + 1)).size() > maxChange) {
                    maxChange = player.moves(moves.get(i), moves.get(i + 1)).size();
                    row = moves.get(i);
                    column = moves.get(i + 1);
                }
            }
        }
        if (!flag && row !=10 && column!=10){
            System.out.println("Computer turn: "+(row+1)+" "+(char)('A'+column));
            player.applyMove(row, column);
        }
    }
}
