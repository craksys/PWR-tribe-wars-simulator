package Move;

import Board.Board_Content;
import Unit.Unit_Details;

public class Move {
    RandMove randMove = new RandMove();
    TargetedMoveUnit targetedMoveUnit = new TargetedMoveUnit();
    Diplomacy diplomacy = new Diplomacy();
    private int speed =5;


        public void unitmove(Board_Content[][] board_content, Unit_Details[] unit_details){
        for(int i =0; i< board_content.length; i++)
        {
            if(unit_details[i].active == true && unit_details[i].stationary == false){
                if(unit_details[i].targetactive == false){
                board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = false; //zmienia zajętość pola
                for(int j =0; j<speed;j++) {
                         randMove.randmove(board_content, unit_details, i);
                    }
                    diplomacy.meetdiplomacy(board_content, unit_details, i);//miejsce na sprawdzenie walki
                    board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = true; //zmienia zajętość pola
                }
                else if(unit_details[i].targetactive == true){
                    board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = false;
                    for(int j =0; j<speed;j++){
                        targetedMoveUnit.movetotargetunit(board_content, unit_details, i);
                    }
                    diplomacy.meetdiplomacy(board_content, unit_details, i);//miejsce na sprawdzenie walki
                    board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = true;
                }

            }else if(unit_details[i].active == true && unit_details[i].stationary == true){}
        }
    }

}
