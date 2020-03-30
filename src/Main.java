import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game=new Game();
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Play with your friend\n2.Play with computer\n3.Play Com vs Com");
        i=sc.nextInt();
        if(i==1) game.gameWithFriend();
        else if(i==2)  game.gameWithComputer();
        else game.gameComWithCom();
    }
}
