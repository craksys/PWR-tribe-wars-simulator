package Unit;

import Board.Board_Content;

import java.util.concurrent.TimeUnit;

public class Unit {

    UnitRandom unitRandom = new UnitRandom();

    public void generateunits(Unit_Details[] unit_details, Board_Content[][] board_content) throws InterruptedException {
        for (int i = 0; i < unit_details.length; i++) {
            unit_details[i] = new Unit_Details();
        }

        for (int i = 0; i < unit_details.length; i++) {
            unitRandom.UnitFill(unit_details, board_content, i);
        }
        return;
    }
}
