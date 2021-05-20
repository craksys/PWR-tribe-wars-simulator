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
                war(unit_details, i, j);
                System.out.println("No to wojna :)");
            }
            if (unit_details[i].type.equals(unit_details[j].type)) { //jezeli 2 jednostki tej samej rasy 25% na polaczenie sie, inaczej wojna
                rannumber = random.nextInt(4);
                if (rannumber == 3) {
                    join(unit_details, i, j); //polaczenie
                }
                else { //jezeli rozna rasa na polu, zawsze wojna
                    war(unit_details, i, j);
                }

            } else {
                war(unit_details, i, j); //wojna
                }
            }

        }


    private void war(Unit_Details[] unit_details, int i, int j){
        if(unit_details[i].quantity > unit_details[j].quantity){
            unit_details[i].quantity -= unit_details[j].quantity;
            unit_details[j].quantity = 0;
            unit_details[j].active = false;
            switchResources(unit_details, i, j, unit_details[i]);
        }
        else if(unit_details[i].quantity < unit_details[j].quantity){
            unit_details[j].quantity -= unit_details[i].quantity;
            unit_details[i].quantity = 0;
            unit_details[i].active = false;
            switchResources(unit_details, j, i, unit_details[i]);
        }
        else{
            unit_details[j].quantity = 0;
            unit_details[j].active = false;
            unit_details[i].quantity = 0;
            unit_details[i].active = false;
            }
    }

    private void join(Unit_Details[] unit_details, int i, int j){
        unit_details[i].quantity += unit_details[j].quantity;
        unit_details[j].quantity = 0;
        unit_details[j].active = false;
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