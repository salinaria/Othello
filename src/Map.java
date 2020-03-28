import java.util.HashMap;

public class Map {
    private int[][] map = new int[8][8];

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public void start() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = 0;
            }
        }
        map[3][3] = 1;
        map[3][4] = -1;
        map[4][3] = -1;
        map[4][4] = 1;
    }

    public void print() {
        System.out.println("    A   B   C   D   E   F   G   H");
        for (int j = 0; j < 8; j++) {
            System.out.print("  +");
            for (int i = 0; i < 8; i++) {
                System.out.print("---+");
            }
            System.out.println("");
            System.out.print(j + 1 + " |");
            for (int i = 0; i < 8; i++) {
                if (map[j][i] == 0) System.out.print("   |");
                else if (map[j][i] == 1) {
                    System.out.print(" x |");
                } else System.out.print(" o |");
            }
            System.out.println("");
        }
        System.out.print("  +");
        for (int i = 0; i < 8; i++) System.out.print("---+");
        System.out.println("");
    }
}
