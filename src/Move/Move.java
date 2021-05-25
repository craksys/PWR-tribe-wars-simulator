package Move;

import Board.Board_Content;
import Unit.Unit_Details;

public class Move {
    RandMove randMove = new RandMove();
    TargetedMoveUnit targetedMoveUnit = new TargetedMoveUnit();
    Diplomacy diplomacy = new Diplomacy();
    SuppliesUpdate suppliesUpdate = new SuppliesUpdate();
    private final int speed = 20;


    public void unitmove(Board_Content[][] board_content, Unit_Details[] unit_details) {
        for (int i = 0; i < unit_details.length; i++) {
            if (unit_details[i].active == true && unit_details[i].stationary == false) {
                if (unit_details[i].targetactive == false) {
                    board_content[(unit_details[i].x_position)][(unit_details[i].y_position)].occupied = false; //zmienia zajętość pola
                    for (int j = 0; j < speed; j++) {
                        randMove.randmove(board_content, unit_details, i);
                    }
                    diplomacy.meetdiplomacy(board_content, unit_details, i);//miejsce na sprawdzenie walki
                } else if (unit_details[i].targetactive == true) {
                    board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = false;
                    for (int j = 0; j < speed; j++) {
                        targetedMoveUnit.movetotargetunit(unit_details, i);
                    }
                    diplomacy.meetdiplomacy(board_content, unit_details, i);//miejsce na sprawdzenie walki
                }

            } else if (unit_details[i].active == true && unit_details[i].stationary == true && unit_details[i].targetactive == false) {
                unit_details[i].x_scouts_position = unit_details[i].x_position;
                unit_details[i].y_scouts_position = unit_details[i].y_position;

            } else if (unit_details[i].active == true && unit_details[i].stationary == true && unit_details[i].targetactive == true) {
                targetedMoveUnit.movetotargetscout(unit_details, i);
            }
        }
    }

}
