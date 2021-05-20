package Move;

import Board.Board_Content;
import Unit.Unit_Details;

import java.util.Random;

public class RandMove {
    Random random = new Random();
    private int x_move;
    private int y_move;

    protected void randmove(Board_Content[][] board_content, Unit_Details[] unit_details, int i){
        x_move = random.nextInt(11)-5;
        y_move = random.nextInt(11)-5;

        unit_details[i].x_position = unit_details[i].x_position + x_move;
        unit_details[i].y_position = unit_details[i].y_position + y_move;

    }
}
