package Move;

import Board.BoardContent;
import Graph.Stats;
import Unit.UnitDetails;

import java.util.Random;

public class Diplomacy {
    Random random = new Random();

    protected void meetDiplomacy(BoardContent[][] boardContent, UnitDetails[] unitDetails, int i) {
        int j = 0;
        if (boardContent[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied) {//sprawdzenie czy zajmowane pole jest już zajęte przez inną jednostkę i interakcja z nią
            Stats.test++;
            for (; j < unitDetails.length; j++) {
                if (unitDetails[i].xPosition == unitDetails[j].xPosition && unitDetails[i].yPosition == unitDetails[j].yPosition && i != j && unitDetails[j].active) {
                    break;
                }
            }
            if (unitDetails[i].hunger < 20 && unitDetails[i].wood < 20 && unitDetails[i].stone < 20 && unitDetails[i].iron < 20) {//bezwarunkowa wojna jezeli jednosta ma malo zasobow
                war(unitDetails, i, j, boardContent);
            }
            if (unitDetails[i].type.equals(unitDetails[j].type)) { //jezeli 2 jednostki tej samej rasy 25% na polaczenie sie, inaczej wojna
                int rnd = random.nextInt(4);
                if (rnd == 3) {
                    join(unitDetails, i, j, boardContent); //polaczenie
                } else {
                    war(unitDetails, i, j, boardContent);
                }
            } else { //jezeli rozna rasa na polu, zawsze wojna
                war(unitDetails, i, j, boardContent); //wojna
            }
        } else { // jeżeli pole nie zajęte to ustaw zajętość
            boardContent[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied = true;
        }

    }


    private void war(UnitDetails[] unitDetails, int i, int j, BoardContent[][] board_content) {
        if (unitDetails[i].quantity > unitDetails[j].quantity) {
            unitDetails[i].quantity -= unitDetails[j].quantity;
            unitDetails[j].quantity = 0;
            unitDetails[j].active = false;
            switchResources(unitDetails, i, j);
            Stats.alive = Stats.alive - 1;
            Stats.deaths++;
            Stats.attacks++;
            board_content[(unitDetails[i].xPosition)][(unitDetails[i].yPosition)].occupied = true;//zmienia zajętość pola
            unitDetails[j].xPosition = -1;
            unitDetails[j].yPosition = -1;
        } else if (unitDetails[i].quantity < unitDetails[j].quantity) {
            unitDetails[j].quantity -= unitDetails[i].quantity;
            unitDetails[i].quantity = 0;
            unitDetails[i].active = false;
            switchResources(unitDetails, j, i);
            Stats.alive = Stats.alive - 1;
            Stats.deaths++;
            Stats.attacks++;
            board_content[(unitDetails[j].xPosition)][(unitDetails[j].yPosition)].occupied = true;//zmienia zajętość pola
            unitDetails[i].xPosition = -1;
            unitDetails[i].yPosition = -1;
        } else if ((unitDetails[i].quantity == unitDetails[j].quantity) && unitDetails[j].quantity != 0 && unitDetails[i].quantity != 0) {
            unitDetails[j].quantity = 0;
            unitDetails[j].active = false;
            unitDetails[i].quantity = 0;
            unitDetails[i].active = false;
            board_content[(unitDetails[i].xPosition)][(unitDetails[i].yPosition)].occupied = false;//zmienia zajętość pola
            unitDetails[j].xPosition = -1;
            unitDetails[j].yPosition = -1;
            unitDetails[i].xPosition = -1;
            unitDetails[i].yPosition = -1;
            Stats.alive = Stats.alive - 2;
            Stats.deaths = Stats.deaths + 2;
            Stats.attacks++;
            Stats.test2++;
        }
    }

    private void join(UnitDetails[] unitDetails, int i, int j, BoardContent[][] boardContent) {
        unitDetails[i].quantity += unitDetails[j].quantity;
        unitDetails[j].quantity = 0;
        unitDetails[j].active = false;
        boardContent[(unitDetails[i].xPosition)][(unitDetails[i].yPosition)].occupied = true;//zmienia zajętość pola
        unitDetails[j].xPosition = -1;
        unitDetails[j].yPosition = -1;
        Stats.alive = Stats.alive - 1;
        Stats.allays++;
        switchResources(unitDetails, i, j);
    }

    private void switchResources(UnitDetails[] unitDetails, int i, int j) {
        unitDetails[i].wood += unitDetails[j].wood;
        if (unitDetails[i].wood > 100) unitDetails[i].wood = 100;
        unitDetails[i].hunger += unitDetails[j].hunger;
        if (unitDetails[i].hunger > 100) unitDetails[i].hunger = 100;
        unitDetails[i].stone += unitDetails[j].stone;
        if (unitDetails[i].stone > 100) unitDetails[i].stone = 100;
        unitDetails[i].iron += unitDetails[j].iron;
        if (unitDetails[i].iron > 100) unitDetails[i].iron = 100;
    }
}