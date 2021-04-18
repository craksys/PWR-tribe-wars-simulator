package board;

import java.util.Random;

public class LocateSources {

    Random random = new Random();

    private int x,y;

    public Board_Content[][] randsupplies(Board_Content[][] board_content, int amountofsupplies,int typeofsupplies){
        for(int i =0; i<amountofsupplies; i++)//1000 oznacza liczbę pół złota na mapie
        {
            x = random.nextInt(1000);
            y = random.nextInt(1000);
            board_content[x][y].type = typeofsupplies; //1 - zloto
            System.out.println(x);
            System.out.println(y);
        }
        return board_content;
    }
}
