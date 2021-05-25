package Move;

import Board.Board_Content;
import Graph.Stats;
import Unit.Unit_Details;

import java.util.Random;

public class Diplomacy {
    Random random = new Random();
    int rannumber;
    protected void meetdiplomacy(Board_Content[][] board_content, Unit_Details[] unit_details, int i) {
        int j=0;
        if (board_content[unit_details[i].x_position][unit_details[i].y_position].occupied == true) {//sprawdzenie czy zajmowane pole jest już zajęte przez inną jednostkę i interakcja z nią
            Stats.test++;
            for(; j < unit_details.length ; j++){
                if(unit_details[i].x_position == unit_details[j].x_position && unit_details[i].y_position == unit_details[j].y_position && i != j && unit_details[j].active == true){
                    break;
                }
            }
        if (unit_details[i].hunger < 20 && unit_details[i].wood < 20 && unit_details[i].stone < 20 && unit_details[i].iron < 20) {//bezwarunkowa wojna jezeli jednosta ma malo zasobow
            war(unit_details, i, j,board_content);
        }
        if (unit_details[i].type.equals(unit_details[j].type)) { //jezeli 2 jednostki tej samej rasy 25% na polaczenie sie, inaczej wojna
            rannumber = random.nextInt(4);
            if (rannumber == 3) {
                join(unit_details, i, j,board_content); //polaczenie
            }
            else {
                war(unit_details, i, j,board_content);
            }
        }
        else { //jezeli rozna rasa na polu, zawsze wojna
            war(unit_details, i, j,board_content); //wojna
        }
    }
    else{ // jeżeli pole nie zajęte to ustaw zajętość
    board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = true;
    }

}



    private void war(Unit_Details[] unit_details, int i, int j, Board_Content[][] board_content){
        if(unit_details[i].quantity > unit_details[j].quantity){
            unit_details[i].quantity -= unit_details[j].quantity;
            unit_details[j].quantity = 0;
            unit_details[j].active = false;
            switchResources(unit_details, i, j, unit_details[i]);
            Stats.alive = Stats.alive -1;
            Stats.deaths++;
            Stats.attacks++;
            board_content[(unit_details[i].x_position)][(unit_details[i].y_position)].occupied = true;//zmienia zajętość pola
            unit_details[j].x_position = -1;
            unit_details[j].y_position = -1;
        }
        else if(unit_details[i].quantity < unit_details[j].quantity){
            unit_details[j].quantity -= unit_details[i].quantity;
            unit_details[i].quantity = 0;
            unit_details[i].active = false;
            switchResources(unit_details, j, i, unit_details[i]);
            Stats.alive = Stats.alive -1;
            Stats.deaths++;
            Stats.attacks++;
            board_content[(unit_details[j].x_position)][(unit_details[j].y_position)].occupied = true;//zmienia zajętość pola
            unit_details[i].x_position = -1;
            unit_details[i].y_position = -1;
        }
        else if((unit_details[i].quantity == unit_details[j].quantity)&& unit_details[j].quantity != 0 && unit_details[i].quantity !=0){
            unit_details[j].quantity = 0;
            unit_details[j].active = false;
            unit_details[i].quantity = 0;
            unit_details[i].active = false;
            board_content[(unit_details[i].x_position)][(unit_details[i].y_position)].occupied = false;//zmienia zajętość pola
            unit_details[j].x_position = -1;
            unit_details[j].y_position = -1;
            unit_details[i].x_position = -1;
            unit_details[i].y_position = -1;
            Stats.alive = Stats.alive -2;
            Stats.deaths = Stats.deaths+2;
            Stats.attacks++;
            Stats.test2++;
            }
    }

    private void join(Unit_Details[] unit_details, int i, int j,Board_Content[][] board_content){
        unit_details[i].quantity += unit_details[j].quantity;
        unit_details[j].quantity = 0;
        unit_details[j].active = false;
        board_content[(unit_details[i].x_position)][(unit_details[i].y_position)].occupied = true;//zmienia zajętość pola
        unit_details[j].x_position = -1;
        unit_details[j].y_position = -1;
        Stats.alive = Stats.alive -1;
        Stats.allays++;
        switchResources(unit_details ,i ,j ,unit_details[i]);
         }

    private void switchResources(Unit_Details[] unit_details, int i, int j, Unit_Details unit_detail) {
        unit_detail.wood += unit_details[j].wood;
        if(unit_details[i].wood > 100) unit_details[i].wood = 100;
        unit_details[i].hunger += unit_details[j].hunger;
        if(unit_details[i].hunger > 100) unit_details[i].hunger = 100;
        unit_details[i].stone += unit_details[j].stone;
        if(unit_details[i].stone > 100) unit_details[i].stone = 100;
        unit_details[i].iron += unit_details[j].iron;
        if(unit_details[i].iron > 100) unit_details[i].iron = 100;
    }
}