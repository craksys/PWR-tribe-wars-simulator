package Board;
import Unit.Unit;
import Unit.Unit_Details;

import java.util.ArrayList;

public class Main
{
    public static void main (String[] args)
    {
        ArrayOfPlaces arrayOfPlaces = new ArrayOfPlaces();
        Board board = new Board();
        Unit unit = new Unit();
        Board_Content[][] board_content = new Board_Content[1000][1000];
        board.createmap(board_content);

        board.placesupplies(board_content, arrayOfPlaces.x_food, arrayOfPlaces.y_food, 20000,1); //żywność
        board.placesupplies(board_content,arrayOfPlaces.x_wood, arrayOfPlaces.y_wood, 10000,2); // drewno
        board.placesupplies(board_content,arrayOfPlaces.x_stone, arrayOfPlaces.y_stone, 10000,3); //kamień
        board.placesupplies(board_content, arrayOfPlaces.x_iron, arrayOfPlaces.y_iron, 5000,4); //żelazo
        board.placesupplies(board_content, arrayOfPlaces.x_gold, arrayOfPlaces.y_gold, 1000,5); //złoto

        Unit_Details[] unit_details = new Unit_Details[5000];
        unit.generateunits(unit_details, board_content);
        }
    }

