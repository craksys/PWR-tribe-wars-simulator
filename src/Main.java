package Board;
import Graph.MyFrame;
import Graph.MyPanel;
import Graph.Test;
import Moving.Move;
import Moving.SelectTarget;
import Unit.Unit;
import Unit.Unit_Details;

import java.awt.*;
import java.util.ArrayList;

public class Main
{
    public static void main (String[] args)
    {
        Board board = new Board();
        Unit unit = new Unit();
        Move move = new Move();

        Board_Content[][] board_content = new Board_Content[1000][1000];
        board.createmap(board_content);

        board.placesupplies(board_content, ArrayOfPlaces.x_food, ArrayOfPlaces.y_food, 20000,1); //żywność
        board.placesupplies(board_content, ArrayOfPlaces.x_wood, ArrayOfPlaces.y_wood, 10000,2); // drewno
        board.placesupplies(board_content, ArrayOfPlaces.x_stone, ArrayOfPlaces.y_stone, 10000,3); //kamień
        board.placesupplies(board_content, ArrayOfPlaces.x_iron, ArrayOfPlaces.y_iron, 5000,4); //żelazo
        board.placesupplies(board_content, ArrayOfPlaces.x_gold, ArrayOfPlaces.y_gold, 1000,5); //złoto

        Unit_Details[] unit_details = new Unit_Details[5000];
        unit.generateunits(unit_details, board_content);
        move.targets(board_content,unit_details);
        MyFrame frame = new MyFrame(board_content);
        System.out.println("koniec");

        }
    }

