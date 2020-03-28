import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player(map);
        map.start();

        Scanner play=new Scanner(System.in);
        System.out.println("1.Play with your friend\n2.Play withe computer");
        int playMode=play.nextInt();
        if(playMode==1){
            Multiple game = new Multiple(map, player);
            game.playWithFriend();

        }
        else{
            System.out.println("This feature is not available ");
        }
    }
}
