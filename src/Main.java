package board;
import Unit.Unit;
import Unit.Unit_Details;

public class Main
{
    public static void main (String[] args)
    {
        Board board = new Board();
        Unit unit = new Unit();
        Board_Content[][] board_content = new Board_Content[1000][1000];
        board.createmap(board_content);
        board.placesupplies(board_content);
        Unit_Details[] unit_details = new Unit_Details[5000];
        unit.generateunits(unit_details, board_content);

        }
    }

