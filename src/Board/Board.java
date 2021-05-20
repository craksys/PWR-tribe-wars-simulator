package Board;


import java.util.ArrayList;

public class Board {
    Board_Content[][] board_content;

    public Board(Board_Content[][] board_content){
        this.board_content = board_content;
    }



    LocateSources locatesources = new LocateSources();

    public void createmap(Board_Content[][] board_content){
        for(int i =0; i<1000; i++)
        {
            for(int k =0; k<1000 ; k++)
            {
                board_content[i][k] = new Board_Content();
            }
        }
        return;
    }

    public void placesupplies(Board_Content[][] board_content,ArrayList<Integer> x_array, ArrayList<Integer> y_array,int amountofsupplies,int typeofsupplies)
    {
        locatesources.randsupplies(board_content, amountofsupplies,typeofsupplies,x_array,y_array); //jedzenie i woda
        return;
    }
}

