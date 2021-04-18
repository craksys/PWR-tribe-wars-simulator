package Unit;

import board.Board_Content;

import java.util.Random;

public class UnitRandom {
    NumberToName numbertoname = new NumberToName();
    Random random = new Random();

    protected void UnitFill(Unit_Details[] unit_details, Board_Content[][] board_content, int i)
    {
        unit_details[i].type = numbertoname.change();
        unit_details[i].hunger = random.nextInt(51) + 30; // procentowo głód
        unit_details[i].stone = random.nextInt(51) + 30; // procentwo ilość kamienia
        unit_details[i].iron = random.nextInt(51) + 30; // procentowo ilość żelaza
        unit_details[i].wood = random.nextInt(51) + 30; // procentowo ilosc drewna
        unit_details[i].gold = random.nextInt(51) + 1; // ilość złotych monet
        unit_details[i].quantity = random.nextInt(9100) + 1000; // liczebność grupy

        if(unit_details[i].quantity>=10000)
        {
            unit_details[i].stationary = true;
        }
        do{
            unit_details[i].x_position = random.nextInt(1000);
            unit_details[i].y_position = random.nextInt(1000);
        }
        while(board_content[unit_details[i].x_position][unit_details[i].y_position].occupied);
        board_content[unit_details[i].x_position][unit_details[i].y_position].occupied = true;
        unit_details[i].x_scouts_position = unit_details[i].x_position;
        unit_details[i].y_scouts_position = unit_details[i].y_position;

    }
}
