package Move;

import Board.BoardContent;
import Unit.UnitDetails;

public class Move {
    RandMove randMove = new RandMove();
    TargetedMoveUnit targetedMoveUnit = new TargetedMoveUnit();
    Diplomacy diplomacy = new Diplomacy();
    private final int speed = 20;


    public void unitMove(BoardContent[][] boardContent, UnitDetails[] unitDetails) {
        for (int i = 0; i < unitDetails.length; i++) {
            if (unitDetails[i].active && !unitDetails[i].stationary) {
                if (!unitDetails[i].targetActive) {
                    boardContent[(unitDetails[i].xPosition)][(unitDetails[i].yPosition)].occupied = false; //zmienia zajętość pola
                    for (int j = 0; j < speed; j++) {
                        randMove.randMove(unitDetails, i);
                    }
                    diplomacy.meetDiplomacy(boardContent, unitDetails, i);//miejsce na sprawdzenie walki
                } else if (unitDetails[i].targetActive) {
                    boardContent[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied = false;
                    for (int j = 0; j < speed; j++) {
                        targetedMoveUnit.moveToTargetUnit(unitDetails, i);
                    }
                    diplomacy.meetDiplomacy(boardContent, unitDetails, i);//miejsce na sprawdzenie walki
                }

            } else if (unitDetails[i].active && unitDetails[i].stationary && !unitDetails[i].targetActive) {
                unitDetails[i].xScoutsPosition = unitDetails[i].xPosition;
                unitDetails[i].yScoutsPosition = unitDetails[i].yPosition;

            } else if (unitDetails[i].active && unitDetails[i].stationary && unitDetails[i].targetActive) {
                targetedMoveUnit.moveToTargetScout(unitDetails, i);
            }
        }
    }

}
