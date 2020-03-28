import java.util.HashMap;

public class Player {
    private Map gameMap;

    public Player(Map gameMap) {
        this.gameMap = gameMap;
    }

    public HashMap<String, Boolean> availableMove(int player, int row, int column) {
        int[][] map = gameMap.getMap();
        HashMap<String, Boolean> availableDirections = new HashMap<String, Boolean>();
        int flag1;
        int flag2;
        //UP
        flag1 = 0;
        flag2 = 0;
        if (row > 0) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column] == player * (-1)) flag1 = 1;
                else if (map[i][column] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
            }
        }

        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("UP", true);
        } else {
            availableDirections.put("UP", false);
        }
        //DOWN
        flag1 = 0;
        flag2 = 0;
        if (row < 7) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column] == player * (-1)) flag1 = 1;
                else if (map[i][column] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
            }
        }
        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("DOWN", true);
        } else {
            availableDirections.put("DOWN", false);
        }


        //RIGHT
        flag1 = 0;
        flag2 = 0;
        if (column < 7) {
            for (int i = column + 1; 8 > i; i++) {
                if (map[row][i] == player * (-1)) {
                    flag1 = 1;
                } else if (map[row][i] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
            }
        }
        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("RIGHT", true);
        } else {
            availableDirections.put("RIGHT", false);
        }
        //LEFT
        flag1 = 0;
        flag2 = 0;
        if (column > 0) {
            for (int i = column - 1; i >= 0; i--) {
                if (map[row][i] == player * (-1)) flag1 = 1;
                else if (map[row][i] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
            }
        }
        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("LEFT", true);
        } else {
            availableDirections.put("LEFT", false);
        }

        int change = 0;
        //UPRIGHT
        flag1 = 0;
        flag2 = 0;
        change = 1;
        if (row > 0 && column < 7) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player * (-1)) flag1 = 1;
                else if (map[i][column + change] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change++;
                else break;
            }
        }
        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("UPRIGHT", true);
        } else {
            availableDirections.put("UPRIGHT", false);
        }


        //DOWNRIGHT
        flag1 = 0;
        flag2 = 0;
        change = 1;
        if (row < 7 && column < 7) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player * (-1)) flag1 = 1;
                else if (map[i][column + change] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change++;
                else break;
            }
        }
        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("DOWNRIGHT", true);
        } else {
            availableDirections.put("DOWNRIGHT", false);
        }


        //UPLEFT
        flag1 = 0;
        flag2 = 0;
        change = -1;
        if (row > 0 && column > 0) {
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player * (-1)) flag1 = 1;
                else if (map[i][column + change] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change--;
                else break;
            }
        }

        if (flag1 == 0 && flag2 == 1) {
            availableDirections.put("UPLEFT", true);
        } else {
            availableDirections.put("UPLEFT", false);
        }
        //DOWNLEFT
        flag1 = 0;
        flag2 = 0;
        change = -1;
        if (row < 7 && column > 0) {
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player * (-1)) flag1 = 1;
                else if (map[i][column + change] == player) {
                    flag2 = 1;
                    break;
                } else {
                    flag1 = 0;
                    break;
                }
                if (column + change < 7 && column + change > 0) change--;
                else break;
            }
        }
        if (flag1 == 1 && flag2 == 1) {
            availableDirections.put("DOWNLEFT", true);
        } else {
            availableDirections.put("DOWNLEFT", false);
        }

        return availableDirections;
    }

    public void move(int player, int row, int column) {
        int[][] map = gameMap.getMap();
        HashMap<String, Boolean> availableMoves = new HashMap<String, Boolean>();
        availableMoves = availableMove(player, row, column);
        if (availableMoves.get("UP")) {
            map[row][column] = player;
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column] == player) break;
                else map[i][column] = player;
            }
        }
        if (availableMoves.get("DOWN")) {
            map[row][column] = player;
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column] == player) break;
                else map[i][column] = player;
            }
        }
        if (availableMoves.get("RIGHT")) {
            map[row][column] = player;
            for (int i = column + 1; 8 > i; i++) {
                if (map[row][i] == player) break;
                else map[row][i] = player;
            }
        }
        if (availableMoves.get("LEFT")) {
            map[row][column] = player;
            for (int i = column - 1; i >= 0; i--) {
                if (map[row][i] == player) break;
                else map[row][i] = player;
            }

        }

        int change;

        change = 1;
        if (availableMoves.get("UPRIGHT")) {
            map[row][column] = player;
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change++;
            }
        }
        change = 1;
        if (availableMoves.get("DOWNRIGHT")) {
            map[row][column] = player;
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change++;
            }
        }
        change = -1;
        if (availableMoves.get("UPLEFT")) {
            map[row][column] = player;
            for (int i = row - 1; i >= 0; i--) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change--;
            }
        }
        change = -1;
        if (availableMoves.get("DOWNLEFT")) {
            map[row][column] = player;
            for (int i = row + 1; 8 > i; i++) {
                if (map[i][column + change] == player) break;
                else map[i][column + change] = player;
                change--;
            }
        }
        gameMap.setMap(map);
    }
}
