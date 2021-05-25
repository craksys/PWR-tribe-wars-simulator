package Move;

import Board.Board_Content;
import Graph.Stats;
import Unit.Unit_Details;

public class SuppliesUpdate {
    public void update(Unit_Details[] unit_details, Board_Content[][] board_content) {
        for (int i = 0; i < unit_details.length; i++) {
            if (unit_details[i].active == true) {
                if (unit_details[i].wood == 0 || unit_details[i].iron == 0 || unit_details[i].hunger == 0 || unit_details[i].stone == 0) {
                    unit_details[i].active = false;
                    unit_details[i].quantity = 0;
                    board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = false;
                    unit_details[i].x_position = -1;
                    unit_details[i].y_position = -1;
                    Stats.alive--;
                } else {
                    unit_details[i].wood -= 1;
                    unit_details[i].stone -= 1;
                    unit_details[i].iron -= 1;
                    unit_details[i].hunger -= 1;
                }
            }
        }
    }
}
