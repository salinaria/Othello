public class RealPlayer extends Player {
    public RealPlayer(Table table, int num) {
        super(table, num);
    }
    public void printAvailableMoves(){
        int numMoves=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(moves(i,j).size()>0){
                    numMoves++;
                    System.out.println(numMoves+")"+(i+1)+" "+(char)('A'+j));
                }
            }
        }
    }
}
