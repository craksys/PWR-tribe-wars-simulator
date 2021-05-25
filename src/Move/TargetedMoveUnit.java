package Move;

import Board.Board_Content;
import Unit.Unit_Details;

public class TargetedMoveUnit {

    protected void movetotargetunit(Unit_Details[] unit_details, int i){
        if(unit_details[i].x_position < unit_details[i].x_target){
            unit_details[i].x_position++;
        }else if(unit_details[i].x_position > unit_details[i].x_target){
            unit_details[i].x_position--;
        }else if(unit_details[i].x_position == unit_details[i].x_target){}
        
        if(unit_details[i].y_position < unit_details[i].y_target){
            unit_details[i].y_position++;
        }else if(unit_details[i].y_position > unit_details[i].y_target){
            unit_details[i].y_position--;
        }else if(unit_details[i].y_position == unit_details[i].y_target){}
    }
    protected void movetotargetscout(Unit_Details[] unit_details, int i){
            if(unit_details[i].x_scouts_position < unit_details[i].x_target){
                unit_details[i].x_scouts_position++;
            }else if(unit_details[i].x_scouts_position > unit_details[i].x_target){
                unit_details[i].x_scouts_position--;
            }else if(unit_details[i].x_scouts_position == unit_details[i].x_target){}

            if(unit_details[i].y_scouts_position < unit_details[i].y_target){
                unit_details[i].y_scouts_position++;
            }else if(unit_details[i].y_scouts_position > unit_details[i].y_target){
                unit_details[i].y_scouts_position--;
            }else if(unit_details[i].y_scouts_position == unit_details[i].y_target){}
        }

    }

