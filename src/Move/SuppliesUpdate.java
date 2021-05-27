package Move;

import Board.BoardContent;
import Graph.Stats;
import Unit.UnitDetails;

public class SuppliesUpdate {
    public void update(UnitDetails[] unitDetails, BoardContent[][] board_content) {
        for (int i = 0; i < unitDetails.length; i++) {
            if(unitDetails[i].xPosition==-1 || unitDetails[i].quantity<=0){unitDetails[i].active=false;}
            if (unitDetails[i].active) {
                if (unitDetails[i].wood == 0 || unitDetails[i].iron == 0 || unitDetails[i].hunger == 0 || unitDetails[i].stone == 0) {
                    unitDetails[i].active = false;
                    unitDetails[i].quantity = 0;
                    board_content[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied = false;
                    unitDetails[i].xPosition = -1;
                    unitDetails[i].yPosition = -1;
                    Stats.alive--;
                    Stats.lackOfResources++;
                } else {
                    unitDetails[i].quantity+=3;
                    if(unitDetails[i].quantity >= 3000){
                        unitDetails[i].stationary = true;
                    }
                    unitDetails[i].wood--;
                    unitDetails[i].stone--;
                    unitDetails[i].iron--;
                    unitDetails[i].hunger--;
                }
            }
        }
    }
}
