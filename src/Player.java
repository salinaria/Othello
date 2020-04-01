import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private Table table;
    private int num;

    public Player(Table table, int num) {
        this.table = table;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public HashMap<String, Boolean> checkAvailable(int row, int column) {
        int[][] tableTester = table.getTable().clone();
        HashMap<String, Boolean> checker = new HashMap<String, Boolean>();
        if (tableTester[row][column] == 0) {
            boolean flag1;
            boolean flag2;
            //UP
            flag1 = false;
            flag2=false;
            for (int i = row - 1; i >= 0; i--) {
                if (tableTester[i][column] == num * (-1)) flag1 = true;
                else if (tableTester[i][column] == num) {
                    flag2=true;
                    break;
                }
                else {
                    flag1 = false;
                    break;
                }
            }
            checker.put("UP", flag1 && flag2);
            //DOWN
            flag1 = false;
            flag2=false;
            for (int i = row + 1; 8 > i; i++) {
                if (tableTester[i][column] == num * (-1)) flag1 = true;
                else if (tableTester[i][column] == num) {
                    flag2=true;
                    break;
                }
                else {
                    flag1 = false;
                    break;
                }
            }
            checker.put("DOWN", flag1 && flag2);
            //RIGHT
            flag1 = false;
            flag2=false;
            for (int i = column + 1; 8 > i; i++) {
                if (tableTester[row][i] == num * (-1)) flag1 = true;
                else if (tableTester[row][i] == num) {
                    flag2=true;
                    break;
                }
                else {
                    flag1 = false;
                    break;
                }
            }
            checker.put("RIGHT", flag1 && flag2);
            //LEFT
            flag1 = false;
            flag2=false;
            for (int i = column - 1; i >=0; i--) {
                if (tableTester[row][i] == num * (-1)) flag1 = true;
                else if (tableTester[row][i] == num) {
                    flag2=true;
                    break;
                }
                else {
                    flag1 = false;
                    break;
                }
            }
            checker.put("LEFT", flag1 && flag2);
            int changer;
            //UPRIGHT
            flag1 = false;
            flag2=false;
            changer = 1;
            for (int i = row - 1; i >=0; i--) {
                if (column + changer > 7) break;
                else {
                    if (tableTester[i][column + changer] == num * (-1)) flag1 = true;
                    else if (tableTester[i][column + changer] == num) {
                        flag2=true;
                        break;
                    }
                    else {
                        flag1 = false;
                        break;
                    }
                }
                changer++;
            }
            checker.put("UPRIGHT", flag1 && flag2);
            //UPLEFT
            flag1 = false;
            flag2=false;
            changer = -1;
            for (int i = row - 1; i >= 0; i--) {
                if (column + changer < 0) break;
                else {
                    if (tableTester[i][column + changer] == num * (-1)) flag1 = true;
                    else if (tableTester[i][column + changer] == num) {
                        flag2=true;
                        break;
                    }
                    else {
                        flag1 = false;
                        break;
                    }
                }
                changer--;
            }
            checker.put("UPLEFT", flag1 && flag2);
            //DOWNRIGHT
            flag1 = false;
            flag2=false;
            changer = 1;
            for (int i = row + 1; 8 > i; i++) {
                if (column + changer > 7) break;
                else {
                    if (tableTester[i][column + changer] == num * (-1)) flag1 = true;
                    else if (tableTester[i][column + changer] == num) {
                        flag2=true;
                        break;
                    }
                    else {
                        flag1 = false;
                        break;
                    }
                }
                changer++;
            }
            checker.put("DOWNRIGHT", flag1 && flag2);
            //DOWNLEFT
            flag1 = false;
            flag2=false;
            changer = -1;
            for (int i = row + 1; 8 > i; i++) {
                if (column + changer < 0) break;
                else {
                    if (tableTester[i][column + changer] == num * (-1)) flag1 = true;
                    else if (tableTester[i][column + changer] == num) {
                        flag2=true;
                        break;
                    }
                    else {
                        flag1 = false;
                        break;
                    }
                }
                changer--;
            }
            checker.put("DOWNLEFT", flag1 && flag2);
        }
        else{
            checker.put("UP",false);
            checker.put("UPRIGHT",false);
            checker.put("UPLEFT",false);
            checker.put("DOWN",false);
            checker.put("DOWNRIGHT",false);
            checker.put("DOWNLEFT",false);
            checker.put("RIGHT",false);
            checker.put("LEFT",false);
        }
        return checker;
    }

    public ArrayList<Integer> moves(int row, int column) {
        int[][] tableTester = table.getTable().clone();
        ArrayList<Integer> moves=new ArrayList<Integer>();
        //UP
        if (checkAvailable(row, column).get("UP")) {
            for (int i = row - 1; i >= 0; i--) {
                if (tableTester[i][column] == num * (-1)){
                    moves.add(i);
                    moves.add(column);
                }
                else break;
            }
        }
        //DOWN
        if (checkAvailable(row, column).get("DOWN")) {
            for (int i = row + 1; 8 > i; i++) {
                if (tableTester[i][column] == num * (-1)){
                    moves.add(i);
                    moves.add(column);
                }
                else break;
            }
        }
        //RIGHT
        if (checkAvailable(row, column).get("RIGHT")) {
            for (int i = column + 1; i < 8; i++) {
                if (tableTester[row][i] == num * (-1)){
                    moves.add(row);
                    moves.add(i);
                }
                else break;
            }
        }
        //LEFT
        if (checkAvailable(row, column).get("LEFT")) {
            for (int i = column - 1; i >=0; i--) {
                if (tableTester[row][i] == num * (-1)){
                    moves.add(row);
                    moves.add(i);
                }
                else break;
            }
        }
        int changer;
        //UPRIGHT
        changer=1;
        if (checkAvailable(row, column).get("UPRIGHT")) {
            for (int i = row - 1; i >= 0; i--) {
                if(column+changer>7)break;
                else {
                    if (tableTester[i][column+changer] == num * (-1)){
                        moves.add(i);
                        moves.add(column+changer);
                    }
                    else break;
                }
                changer++;
            }
        }
        //UPLEFT
        changer=-1;
        if (checkAvailable(row, column).get("UPLEFT")) {
            for (int i = row - 1; i >= 0; i--) {
                if(column+changer<0)break;
                else {
                    if (tableTester[i][column+changer] == num * (-1)){
                        moves.add(i);
                        moves.add(column+changer);
                    }
                    else break;
                }
                changer--;
            }
        }
        //DOWNRIGHT
        changer=1;
        if (checkAvailable(row, column).get("DOWNRIGHT")) {
            for (int i = row + 1; i<8; i++) {
                if(column+changer>7)break;
                else {
                    if (tableTester[i][column+changer] == num * (-1)){
                        moves.add(i);
                        moves.add(column+changer);
                    }
                    else break;
                }
                changer++;
            }
        }
        //DOWNLEFT
        changer=-1;
        if (checkAvailable(row, column).get("DOWNLEFT")) {
            for (int i = row + 1; i<8; i++) {
                if(column+changer<0)break;
                else {
                    if (tableTester[i][column+changer] == num * (-1)){
                        moves.add(i);
                        moves.add(column+changer);
                    }
                    else break;
                }
                changer--;
            }
        }
        if(moves.size()>0){
            moves.add(row);
            moves.add(column);
        }
        return moves;
    }
    public ArrayList<Integer> availableMoves() {
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moves(i, j).size() > 0) {
                    moves.add(i);
                    moves.add(j);
                }
            }
        }
        return moves;
    }
    public void applyMove(int row,int column){
        int [][]tab=table.getTable();
        ArrayList<Integer>moves=moves(row,column);
        for(int i=0;i<moves.size();i=i+2){
            tab[moves.get(i)][moves.get(i+1)]=num;
        }
    }
}
