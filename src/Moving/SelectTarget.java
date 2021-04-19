package Moving;

import Board.Board_Content;
import Unit.Unit_Details;

public class SelectTarget {

    public void selecttarger(Unit_Details[] unit_details, int i) {
        if (unit_details[i].targetactive == true) {
            if (unit_details[i].stationary == false) {
                if (unit_details[i].x_position == unit_details[i].x_target && unit_details[i].y_position == unit_details[i].y_target) {
                    refillsupplies(unit_details, i);

                }

            } else if (unit_details[i].stationary == true) {
                if (unit_details[i].x_scouts_position == unit_details[i].x_target && unit_details[i].y_target == unit_details[i].y_scouts_position) {
                    refillsupplies(unit_details, i);

                }

            }
        }

        if(unit_details[i].targetactive == false){
            if(unit_details[i].hunger < 30){}
            else if(unit_details[i].hunger < 20){}
            else if(unit_details[i].wood < 20){}
            else if(unit_details[i].stone < 20){}
            else if(unit_details[i].iron < 20){}
            else if(unit_details[i].gold < 20){}

        }

    }

    private void refillsupplies(Unit_Details[] unit_details, int i) {
        unit_details[i].targetactive = false;
        unit_details[i].x_target = 0;
        unit_details[i].y_target = 0;
        switch(unit_details[i].targettype){
            case 1 -> unit_details[i].hunger = unit_details[i].hunger + 40;
            case 2 -> unit_details[i].wood = unit_details[i].wood +40;
            case 3 -> unit_details[i].stone = unit_details[i].stone + 40;
            case 4 -> unit_details[i].iron = unit_details[i].iron + 40;
            case 5 -> unit_details[i].gold = unit_details[i].gold + 5;
            default -> System.out.println("Błąd w pliku SelectTarget");
        }
        unit_details[i].targettype =0;
    }
}