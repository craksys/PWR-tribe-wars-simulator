package Moving;

import Board.ArrayOfPlaces;
import Board.Board_Content;
import Unit.Unit_Details;

import java.util.Random;

public class Move {
    Random random = new Random();
    SelectTarget selectTarget = new SelectTarget();



    public void targets(Board_Content[][] board_content, Unit_Details[] unit_details)
    {
        for(int i=0; i< unit_details.length;i++){
            
        if (unit_details[i].active == false) {
            return;
        }else{
            selectTarget.selecttarger(unit_details, i);
        }

    }
    }
}
