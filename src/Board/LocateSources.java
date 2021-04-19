package Board;

import java.util.ArrayList;
import java.util.Random;

public class LocateSources {

    Random random = new Random();

    private int x,y;

    public void randsupplies(Board_Content[][] board_content, int amountofsupplies, int typeofsupplies, ArrayList<Integer> x_array, ArrayList<Integer> y_array){
        for(int i =0; i<amountofsupplies; i++)
        {
            do {
                x = random.nextInt(1000);
                y = random.nextInt(1000);
            }
            while(board_content[x][y].type != 0);

            board_content[x][y].type = typeofsupplies;
            x_array.add(x);
            y_array.add(y);
        }
        return;
    }
}
