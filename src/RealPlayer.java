/**
 * @author Ali Ansari
 * @version 1.0
 * This class work for player turns
 */
public class RealPlayer extends Player {
    /**
     * Constructor for RealPlayer
     *
     * @param table The table player play on it
     * @param num   The player's num
     */
    public RealPlayer(Table table, int num) {
        super(table, num);
    }

    /**
     * This function print available moves on the table player can
     */
    public void printAvailableMoves() {
        int numMoves = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moves(i, j).size() > 0) {
                    numMoves++;
                    System.out.println(numMoves + ")" + (i + 1) + " " + (char) ('A' + j));
                }
            }
        }
    }
}
