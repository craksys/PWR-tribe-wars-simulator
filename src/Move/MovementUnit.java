package Move;

import Unit.UnitDetails;

public class MovementUnit extends Movement{
    protected void move(UnitDetails[] unitDetails, int i) {
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
}
