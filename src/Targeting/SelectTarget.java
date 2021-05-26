package Targeting;

import Unit.UnitDetails;

public class SelectTarget {
    FindNearTarget findNearTarget = new FindNearTarget();

    public void selectTarget(UnitDetails[] unitDetails, int i) {
        if (unitDetails[i].targetActive) {
            if (!unitDetails[i].stationary) {
                if (unitDetails[i].xPosition == unitDetails[i].xTarget && unitDetails[i].yPosition == unitDetails[i].yTarget) {
                    refillSupplies(unitDetails, i);

                }

            } else if (unitDetails[i].stationary) {
                if (unitDetails[i].xScoutsPosition == unitDetails[i].xTarget && unitDetails[i].yTarget == unitDetails[i].yScoutsPosition) {
                    refillSupplies(unitDetails, i);

                }

            }
        } else if (!unitDetails[i].targetActive) {
            if (unitDetails[i].hunger < 30) {
                unitDetails[i].targetType = 1;
            } else if (unitDetails[i].wood < 30) {
                unitDetails[i].targetType = 2;
            } else if (unitDetails[i].stone < 30) {
                unitDetails[i].targetType = 3;
            } else if (unitDetails[i].iron < 30) {
                unitDetails[i].targetType = 4;
            }
            findNearTarget.findTargetAndWriteToTab(unitDetails, i);
        }

    }

    private void refillSupplies(UnitDetails[] unitDetails, int i) {
        unitDetails[i].targetActive = false;
        unitDetails[i].xTarget = 0;
        unitDetails[i].yTarget = 0;
        switch (unitDetails[i].targetType) {
            case 1 -> unitDetails[i].hunger = unitDetails[i].hunger + 40;
            case 2 -> unitDetails[i].wood = unitDetails[i].wood + 40;
            case 3 -> unitDetails[i].stone = unitDetails[i].stone + 40;
            case 4 -> unitDetails[i].iron = unitDetails[i].iron + 40;
            default -> System.out.println("Błąd w pliku SelectTarget");
        }
        unitDetails[i].targetType = 0;
    }
}