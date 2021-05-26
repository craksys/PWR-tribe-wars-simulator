package Move;

import Unit.UnitDetails;

public class TargetedMoveUnit {

    protected void moveToTargetUnit(UnitDetails[] unitDetails, int i) {
        if (unitDetails[i].xPosition < unitDetails[i].xTarget) {
            unitDetails[i].xPosition++;
        } else if (unitDetails[i].xPosition > unitDetails[i].xTarget) {
            unitDetails[i].xPosition--;
        }

        if (unitDetails[i].yPosition < unitDetails[i].yTarget) {
            unitDetails[i].yPosition++;
        } else if (unitDetails[i].yPosition > unitDetails[i].yTarget) {
            unitDetails[i].yPosition--;
        }
    }

    protected void moveToTargetScout(UnitDetails[] unitDetails, int i) {
        if (unitDetails[i].xScoutsPosition < unitDetails[i].xTarget) {
            unitDetails[i].xScoutsPosition++;
        } else if (unitDetails[i].xScoutsPosition > unitDetails[i].xTarget) {
            unitDetails[i].xScoutsPosition--;
        }

        if (unitDetails[i].yScoutsPosition < unitDetails[i].yTarget) {
            unitDetails[i].yScoutsPosition++;
        } else if (unitDetails[i].yScoutsPosition > unitDetails[i].yTarget) {
            unitDetails[i].yScoutsPosition--;
        }
    }

}

