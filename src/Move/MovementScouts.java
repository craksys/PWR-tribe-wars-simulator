package Move;

import Unit.UnitDetails;

public class MovementScouts extends Movement{
    protected void move(UnitDetails[] unitDetails, int i) {
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
