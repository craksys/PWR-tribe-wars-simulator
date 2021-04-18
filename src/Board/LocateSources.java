package Board;

import java.util.Random;

public class LocateSources {

    Random random = new Random();

    private int x,y;

    public void randsupplies(Board_Content[][] board_content, int amountofsupplies,int typeofsupplies){
        for(int i =0; i<amountofsupplies; i++)
        {
            x = random.nextInt(1000);
            y = random.nextInt(1000);
            board_content[x][y].type = typeofsupplies; 
        }
        return;
    }
}
