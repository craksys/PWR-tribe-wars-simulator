package Move;

import Board.Board_Content;
import Unit.Unit_Details;

import java.util.Random;

public class Diplomacy {
    Random random = new Random();
    private int j; //nr. jednostki znalezionej na polu okupowanym

    protected void meetdiplomacy(Board_Content[][] board_content, Unit_Details[] unit_details, int i) {
        int rannumber;
        if (board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = true) { //sprawdzenie czy zajmowane pole jest już zajęte przez inną jednostkę
            for (j = 0; j < board_content.length; j++) { //znajdz jednostkę z którą bedzie interakcja
                if ((unit_details[j].x_position == unit_details[i].x_position && unit_details[j].y_position == unit_details[i].y_position) && j != i) {
                    break;
                }
            }
            if (unit_details[i].hunger < 20 && unit_details[i].wood < 20 && unit_details[i].stone < 20 && unit_details[i].iron < 20) {//bezwarunkowa wojna jezeli jednosta ma malo zasobow
                war(board_content, unit_details, i, j);
                System.out.println("No to wojna :)");
            }
            if (unit_details[i].type.equals(unit_details[j].type)) { //jezeli 2 jednostki tej samej rasy 25% na polaczenie sie, inaczej wojna
                rannumber = random.nextInt(4);
                if (rannumber == 3) {
                    join(board_content, unit_details, i, j); //polaczenie
                }
                else { //jezeli rozna rasa na polu, zawsze wojna
                    war(board_content, unit_details, i, j);
                }

            } else {
                war(board_content, unit_details, i, j); //wojna
                }
            }

        }



    private void war(Board_Content[][] board_content, Unit_Details[] unit_details, int i, int j){
        if(unit_details[i].quantity > unit_details[j].quantity){
            unit_details[i].quantity -= unit_details[j].quantity;
            unit_details[j].quantity = 0;
            unit_details[j].active = false;
            unit_details[i].wood =80;
            unit_details[i].hunger =80;
            unit_details[i].stone=80;
            unit_details[i].iron =80;
            }
        else if(unit_details[i].quantity < unit_details[j].quantity){
            unit_details[j].quantity -= unit_details[i].quantity;
            unit_details[i].quantity = 0;
            unit_details[i].active = false;
            unit_details[j].wood =80;
            unit_details[j].hunger =80;
            unit_details[j].stone=80;
            unit_details[j].iron =80;
        }
        else{
            unit_details[j].quantity = 0;
            unit_details[j].active = false;
            unit_details[i].quantity = 0;
            unit_details[i].active = false;
            }
    }

    private void join(Board_Content[][] board_content, Unit_Details[] unit_details, int i, int j){
        unit_details[i].quantity += unit_details[j].quantity;
        unit_details[i].wood = 70;
        unit_details[i].hunger = 70;
        unit_details[i].stone= 70;
        unit_details[i].iron = 70;
        unit_details[j].quantity = 0;
        unit_details[j].active = false;
         }

}