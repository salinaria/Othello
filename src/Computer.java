import java.util.ArrayList;

public class Computer extends Player {
    public Computer(Table table, int num) {
        super(table, num);
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
                applyMove(moves.get(i), moves.get(i + 1));
                flag = true;
                break;
            } else if ((moves.get(i) == 0 && moves.get(i + 1) == 2) || (moves.get(i) == 0 && moves.get(i + 1) == 5) || (moves.get(i) == 7 && moves.get(i + 1) == 2) || (moves.get(i) == 7 && moves.get(i + 1) == 5)) {
                System.out.println("Computer turn: "+(moves.get(i)+1)+" "+(char)('A'+moves.get(i+1)));
                applyMove(moves.get(i), moves.get(i + 1));
                flag = true;
                break;
            } else {
                if (moves(moves.get(i), moves.get(i + 1)).size() > maxChange) {
                    maxChange = moves(moves.get(i), moves.get(i + 1)).size();
                    row = moves.get(i);
                    column = moves.get(i + 1);
                }
            }
        }
        if (!flag && row !=10 && column!=10){
            System.out.println("Computer turn: "+(row+1)+" "+(char)('A'+column));
            applyMove(row, column);
        }
    }
}
