public class Table {
    private int [][]table=new int[8][8];

    public int[][] getTable() {
        return table;
    }

    /**
     * This function get 0 to all cells of table and then get 2 black and 2 white disk in center of table
     */
    public void start() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = 0;
            }
        }
        table[3][3] = 1;
        table[3][4] = -1;
        table[4][3] = -1;
        table[4][4] = 1;
    }

    /**
     * This function print table
     */
    public void print() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        System.out.println("    A   B   C   D   E   F   G   H");
        for (int j = 0; j < 8; j++) {
            System.out.print("  +");
            for (int i = 0; i < 8; i++) {
                System.out.print("---+");
            }
            System.out.println("");
            System.out.print(j + 1 + " |");
            for (int i = 0; i < 8; i++) {
                if (table[j][i] == 0) System.out.print("   |");
                else if (table[j][i] == 1) {
                    System.out.print(ANSI_WHITE_BACKGROUND+"   "+ANSI_RESET+"|");
                } else System.out.print(ANSI_GREEN_BACKGROUND+"   "+ANSI_RESET+"|");
            }
            System.out.println("");
        }
        System.out.print("  +");
        for (int i = 0; i < 8; i++) System.out.print("---+");
        System.out.println("");
    }
}
