package Moving;

import Board.Board_Content;
import Unit.Unit_Details;

import java.util.Random;

public class Move {
    Random random = new Random();



    public void moveunit(Board_Content[][] board_content, Unit_Details[] unit_details, int i)
    {
        if(unit_details[i].active == false)
        {
            return;
        }


    }
}
