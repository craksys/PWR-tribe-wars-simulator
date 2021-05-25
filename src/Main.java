import Board.*;
import Graph.MyFrame;
import Move.Move;
import Move.SuppliesUpdate;
import Targeting.Target;
import Unit.Unit;
import Unit.Unit_Details;
import Graph.Stats;
import Write.WriteToFile;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Unit unit = new Unit();
        Target target = new Target();
        int user_units_quantity = 5000;
        Stats.alive = user_units_quantity;


        Board_Content[][] board_content = new Board_Content[1000][1000];
        Board board = new Board(board_content);
        board.createmap(board_content);

        board.placesupplies(board_content, ArrayOfPlaces.x_food, ArrayOfPlaces.y_food, 2000, 1); //żywność
        board.placesupplies(board_content, ArrayOfPlaces.x_wood, ArrayOfPlaces.y_wood, 1000, 2); // drewno
        board.placesupplies(board_content, ArrayOfPlaces.x_stone, ArrayOfPlaces.y_stone, 1000, 3); //kamień
        board.placesupplies(board_content, ArrayOfPlaces.x_iron, ArrayOfPlaces.y_iron, 500, 4); //żelazo
        board.placesupplies(board_content, ArrayOfPlaces.x_gold, ArrayOfPlaces.y_gold, 100, 5); //złoto

        Unit_Details[] unit_details = new Unit_Details[user_units_quantity];

        unit.generateunits(unit_details, board_content);
        target.targets(board_content, unit_details);

        Move move = new Move();
        SuppliesUpdate suppliesUpdate = new SuppliesUpdate();

        MyFrame frame = new MyFrame(board_content);
        //MyFrameInput fram2 = new MyFrameInput();
        System.out.println("koniec");
        TimeUnit.SECONDS.sleep(4);

        for (int i = 0; i < 100; i++) { //i liczba rund do symulowania
            target.targets(board_content, unit_details);
            move.unitmove(board_content, unit_details);
            suppliesUpdate.update(unit_details, board_content);
        }

        TimeUnit.SECONDS.sleep(4);
        frame.update(frame.getGraphics());


        for (int i = 0; i < 5000; i++) {
            if (unit_details[i].active == true) {
                Stats.rounds++;
            }
        }
        System.out.println("Tyle sojuszy nawiązano: " + Stats.allays);
        System.out.println("Tyle żywych w tablicy: " + Stats.rounds); //ile w tablicy alive
        System.out.println("Tyle interakcji: " + Stats.test);
        System.out.println("Tyle walk z remisem: " + Stats.test2);
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.write();


    }
}

