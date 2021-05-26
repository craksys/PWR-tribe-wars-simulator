package Targeting;

import Unit.UnitDetails;


public class Target {
    SelectTarget selectTarget = new SelectTarget();


    public void targets(UnitDetails[] unitDetails) {
        for (int i = 0; i < unitDetails.length; i++) {
            if (unitDetails[i].active) {
                selectTarget.selectTarget(unitDetails, i);
            }
        }
    }
}
