package Move;

import Board.Board_Content;
import Unit.Unit_Details;

public class TargetedMoveUnit {

    protected void movetotargetunit(Board_Content[][] board_content, Unit_Details[] unit_details, int i){
        if(unit_details[i].x_position < unit_details[i].x_target){
            unit_details[i].x_position++;
        }else if(unit_details[i].x_position > unit_details[i].x_target){
            unit_details[i].x_position--;
        }else if(unit_details[i].x_position == unit_details[i].x_target){System.out.println("Jednostka na miejscu x");}
        
        if(unit_details[i].y_position < unit_details[i].y_target){
            unit_details[i].y_position++;
        }else if(unit_details[i].y_position > unit_details[i].y_target){
            unit_details[i].y_position--;
        }else if(unit_details[i].y_position == unit_details[i].y_target){System.out.println("Jednostka na miejscu y");}
    }
    protected void movetotargetscout(Board_Content[][] board_content, Unit_Details[] unit_details, int i){

    }
}
