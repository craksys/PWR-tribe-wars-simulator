package Move;

import Board.BoardContent;
import Unit.UnitDetails;

public class Move {
    Movement movement = new Movement();
    MovementScouts movementScouts = new MovementScouts();
    MovementUnit movementUnit = new MovementUnit();
    Diplomacy diplomacy = new Diplomacy();


    public void unitMove(BoardContent[][] boardContent, UnitDetails[] unitDetails, int speed) {
        for (int i = 0; i < unitDetails.length; i++) {
            if (unitDetails[i].active) {
                if (!unitDetails[i].stationary) {
                    if (!unitDetails[i].targetActive) {
                        boardContent[(unitDetails[i].xPosition)][(unitDetails[i].yPosition)].occupied = false; //zmienia zajętość pola
                        for (int j = 0; j < speed; j++) {
                            movement.randMove(unitDetails, i);
                        }
                        diplomacy.meetDiplomacy(boardContent, unitDetails, i);//miejsce na sprawdzenie walki
                    } else if (unitDetails[i].targetActive) {
                        boardContent[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied = false;
                        for (int j = 0; j < speed; j++) {
                            movementUnit.move(unitDetails, i);
                        }
                        diplomacy.meetDiplomacy(boardContent, unitDetails, i);//miejsce na sprawdzenie walki
                    }

                } else if (unitDetails[i].stationary && !unitDetails[i].targetActive) {
                    unitDetails[i].xScoutsPosition = unitDetails[i].xPosition;
                    unitDetails[i].yScoutsPosition = unitDetails[i].yPosition;

                } else if (unitDetails[i].active && unitDetails[i].stationary && unitDetails[i].targetActive) {
                    movementScouts.move(unitDetails,i);
                    //movement.moveToTargetScout(unitDetails, i);
                }
            }
        }
    }

}
