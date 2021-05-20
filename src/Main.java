import Board.*;
import Graph.MyFrame;
import Targeting.Target;
import Unit.Unit;
import Unit.Unit_Details;

public class Main
{
    public static void main (String[] args)
    {
        Unit unit = new Unit();
        Target target = new Target();

        Board_Content[][] board_content = new Board_Content[1000][1000];
        Board board = new Board(board_content);
        board.createmap(board_content);

        board.placesupplies(board_content, ArrayOfPlaces.x_food, ArrayOfPlaces.y_food, 20000,1); //żywność
        board.placesupplies(board_content, ArrayOfPlaces.x_wood, ArrayOfPlaces.y_wood, 10000,2); // drewno
        board.placesupplies(board_content, ArrayOfPlaces.x_stone, ArrayOfPlaces.y_stone, 10000,3); //kamień
        board.placesupplies(board_content, ArrayOfPlaces.x_iron, ArrayOfPlaces.y_iron, 5000,4); //żelazo
        board.placesupplies(board_content, ArrayOfPlaces.x_gold, ArrayOfPlaces.y_gold, 1000,5); //złoto

        Unit_Details[] unit_details = new Unit_Details[5000];
        unit.generateunits(unit_details, board_content);
        target.targets(board_content,unit_details);
        MyFrame frame = new MyFrame(board_content);
        System.out.println("koniec");

        }
    }

