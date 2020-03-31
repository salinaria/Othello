import java.util.Scanner;

public class Game {
    private Table table=new Table();
    public void gameWithFriend(){
        table.start();
        Player player1=new Player(table,1);
        Player player2=new Player(table,-1);
        int turn=1;
        while(player1.availableMoves()!=0 || player2.availableMoves()==0){
            table.print();
            if(turn%2==1){
                player1.printAvailableMoves();
                if(player1.availableMoves()==0) System.out.println("Pass!");
                else {
                    System.out.print("Player 1(Black) turn:");
                    Scanner scanner=new Scanner(System.in);
                    int row=scanner.nextInt();
                    int column=scanner.next().charAt(0)-'A';
                    player1.applyMove(row-1,column);
                }
            }
            else{
                if(player2.availableMoves()==0) System.out.println("Pass!");
                else{
                    player2.printAvailableMoves();
                    System.out.print("Player 2(Green) turn:");
                    Scanner scanner=new Scanner(System.in);
                    int row=scanner.nextInt();
                    int column=scanner.next().charAt(0)-'A';
                    player2.applyMove(row-1,column);

                }
            }
            turn++;
        }
        int sumPlayer1=0;
        int sumPlayer2=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(table.getTable()[i][j]==1)sumPlayer1++;
                else if(table.getTable()[i][j]==-1)sumPlayer2++;
            }
        }
        table.print();
        System.out.println("You : "+ sumPlayer1+ "Player 2 : "+sumPlayer2);
        if(sumPlayer1>sumPlayer2) System.out.println("Player 1(Black) win :)");
        else if(sumPlayer1<sumPlayer2) System.out.println("Player 2(Green) win :)");
        else System.out.println("Draw :(");
    }
    public void gameWithComputer() {
        table.start();
        Player player1=new Player(table,1);
        Player player2=new Player(table,-1);
        Computer computer = new Computer(table,player2);
        int turn = 1;
        while (player1.availableMoves() != 0 || computer.availableMoves().size()!= 0) {
            table.print();
            if (turn % 2 == 1) {
                player1.printAvailableMoves();
                if (player1.availableMoves() == 0) System.out.println("Pass!");
                else {
                    System.out.print("Your turn:");
                    Scanner scanner = new Scanner(System.in);
                    int row = scanner.nextInt();
                    int column = scanner.next().charAt(0) - 'A';
                    player1.applyMove(row - 1, column);
                }
            } else {
                computer.chooseMove();
            }
            turn++;
        }
        int sumPlayer1=0;
        int sumPlayer2=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(table.getTable()[i][j]==1)sumPlayer1++;
                else if(table.getTable()[i][j]==-1)sumPlayer2++;
            }
        }
        System.out.println("You : "+ sumPlayer1+ " Computer : "+sumPlayer2);
        if(sumPlayer1>sumPlayer2) System.out.println("You win :)");
        else if(sumPlayer1<sumPlayer2) System.out.println("You lose :(");
        else System.out.println("Draw :(");
    }
    public void gameComWithCom(){
        table.start();
        Player player1=new Player(table,1);
        Computer computer1=new Computer(table,player1);
        Player player2=new Player(table,-1);
        Computer computer2 = new Computer(table,player2);
        int turn=1;
        while(computer1.availableMoves().size()!=0 || computer2.availableMoves().size()!=0){
            table.print();
            if(turn%2==1)computer1.chooseMove();
            else computer2.chooseMove();
            turn++;
        }
        int sumPlayer1=0;
        int sumPlayer2=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(table.getTable()[i][j]==1)sumPlayer1++;
                else if(table.getTable()[i][j]==-1)sumPlayer2++;
            }
        }
        System.out.println("Computer1 : "+ sumPlayer1+ " Computer2 : "+sumPlayer2);
        if(sumPlayer1>sumPlayer2) System.out.println("Com1 win :)");
        else if(sumPlayer1<sumPlayer2) System.out.println("Com2 win :)");
        else System.out.println("Draw :(");
    }
}
