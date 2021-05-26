package Move;

import Unit.UnitDetails;

import java.util.Random;

public class RandMove {
    Random random = new Random();

    protected void randMove(UnitDetails[] unitDetails, int i) {
        int x_move;
        int y_move;
        do {
            x_move = random.nextInt(11) - 5;
            y_move = random.nextInt(11) - 5;
        }
        while ((unitDetails[i].xPosition + x_move < 0 || unitDetails[i].xPosition + x_move > 999) || (unitDetails[i].yPosition + y_move < 0 || unitDetails[i].yPosition + y_move > 999));

        unitDetails[i].xPosition = unitDetails[i].xPosition + x_move;
        unitDetails[i].yPosition = unitDetails[i].yPosition + y_move;

    }
}
