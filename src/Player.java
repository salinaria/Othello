import java.util.HashMap;

public class Player {
    private Map gameMap;

    public Player(Map gameMap) {
        this.gameMap = gameMap;
    }

    public HashMap<String, Boolean> availableMove(int player, int row, int column) {
        int[][] map = gameMap.getMap();
        HashMap<String, Boolean> availableDirections = new HashMap<String, Boolean>();
        int flag;
        //UP
        flag = 0;
        if (row > 0) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column] == player * (-1)) flag = 1;
                else if (map[i][column] == player) break;
                else {
                    flag = 0;
                    break;
                }
            }
        }

        if (flag == 0) {
            availableDirections.put("UP", false);
        } else {
            availableDirections.put("UP", true);
        }
        //DOWN
        flag = 0;
        if (row < 7) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column] == player * (-1)) flag = 1;
                else if (map[i][column] == player) break;
                else {
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == 0) {
            availableDirections.put("DOWN", false);
        } else {
            availableDirections.put("DOWN", true);
        }


        //RIGHT
        flag = 0;
        if (column < 7) {
            for (int i = column + 1; 8 > i; i++) {
                if (map[row][i] == player * (-1)) {
                    flag = 1;
                } else if (map[row][i] == player) break;
                else {
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == 0) {
            availableDirections.put("RIGHT", false);
        } else {
            availableDirections.put("RIGHT", true);
        }
        //LEFT
        flag = 0;
        if (column > 0) {
            for (int i = column - 1; i >= 0; i--) {
                if (map[row][i] == player * (-1)) flag = 1;
                else if (map[row][i] == player) break;
                else {
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == 0) {
            availableDirections.put("LEFT", false);
        } else {
            availableDirections.put("LEFT", true);
        }

        int change = 0;
        //UPRIGHT
        flag = 0;
        change = 1;
        if (row > 0 && column < 7) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player * (-1)) flag = 1;
                else if (map[i][column + change] == player) break;
                else {
                    flag = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change++;
                else break;
            }
        }
        if (flag == 0) {
            availableDirections.put("UPRIGHT", false);
        } else {
            availableDirections.put("UPRIGHT", true);
        }


        //DOWNRIGHT
        flag = 0;
        change = 1;
        if (row < 7 && column < 7) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player * (-1)) flag = 1;
                else if (map[i][column + change] == player) break;
                else {
                    flag = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change++;
                else break;
            }
        }
        if (flag == 0) {
            availableDirections.put("DOWNRIGHT", false);
        } else {
            availableDirections.put("DOWNRIGHT", true);
        }


        //UPLEFT
        flag = 0;
        change = -1;
        if (row > 0 && column > 0) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player * (-1)) flag = 1;
                else if (map[i][column + change] == player) break;
                else {
                    flag = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change--;
                else break;
            }
        }

        if (flag == 0) {
            availableDirections.put("UPLEFT", false);
        } else {
            availableDirections.put("UPLEFT", true);
        }
        //DOWNLEFT
        flag = 0;
        change = -1;
        if (row < 7 && column > 0) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player * (-1)) flag = 1;
                else if (map[i][column + change] == player) break;
                else {
                    flag = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change--;
                else break;
            }
        }
        if (flag == 0) {
            availableDirections.put("DOWNLEFT", false);
        } else {
            availableDirections.put("DOWNLEFT", true);
        }

        return availableDirections;
    }

    public void move(int player, int row, int column) {
        int[][] map = gameMap.getMap();
        HashMap<String, Boolean> availableMoves = new HashMap<String, Boolean>();
        availableMoves = availableMove(player, row, column);
        if (availableMoves.size() > 0) map[row][column] = player;
        if (availableMoves.get("UP")) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column] == player) break;
                else map[i][column] = player;
            }
        }
        if (availableMoves.get("DOWN")) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column] == player) break;
                else map[i][column] = player;
            }
        }
        if (availableMoves.get("RIGHT")) {
            for (int i = column + 1; 8 > i; i++) {
                if (map[row][i] == player) break;
                else map[row][i] = player;
            }
        }
        if (availableMoves.get("LEFT")) {
            for (int i = column - 1; i >= 0; i--) {
                if (map[row][i] == player) break;
                else map[row][i] = player;
            }

        }

        int change;

        change = 1;
        if (availableMoves.get("UPRIGHT")) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change++;
            }
        }
        change = 1;
        if (availableMoves.get("DOWNRIGHT")) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change++;
            }
        }
        change = -1;
        if (availableMoves.get("UPLEFT")) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change--;
            }
        }
        change = -1;
        if (availableMoves.get("DOWNLEFT")) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change--;
            }
        }
        gameMap.setMap(map);
    }
}
