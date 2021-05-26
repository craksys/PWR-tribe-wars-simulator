package Unit;

import Board.BoardContent;

public class Unit {

    UnitRandom unitRandom = new UnitRandom();

    public void generateUnits(UnitDetails[] unitDetails, BoardContent[][] boardContent) {
        for (int i = 0; i < unitDetails.length; i++) {
            unitDetails[i] = new UnitDetails();
        }

        for (int i = 0; i < unitDetails.length; i++) {
            unitRandom.unitFill(unitDetails, boardContent, i);
        }
    }
}
