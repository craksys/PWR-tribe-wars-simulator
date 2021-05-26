import Board.*;
import Graph.MyFrame;
import Move.Move;
import Move.SuppliesUpdate;
import Targeting.Target;
import Unit.Unit;
import Unit.UnitDetails;
import Graph.Stats;
import Write.WriteToFile;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Unit unit = new Unit();
        Target target = new Target();
        int userUnitsQuantity = 5000;
        Stats.alive = userUnitsQuantity;


        BoardContent[][] boardContent = new BoardContent[1000][1000];
        Board board = new Board(boardContent);
        board.createMap(boardContent);

        board.placeSupplies(boardContent, ArrayOfPlaces.xFood, ArrayOfPlaces.yFood, 2000, 1); //żywność
        board.placeSupplies(boardContent, ArrayOfPlaces.xWood, ArrayOfPlaces.yWood, 1000, 2); // drewno
        board.placeSupplies(boardContent, ArrayOfPlaces.xStone, ArrayOfPlaces.yStone, 1000, 3); //kamień
        board.placeSupplies(boardContent, ArrayOfPlaces.xIron, ArrayOfPlaces.yIron, 500, 4); //żelazo

        UnitDetails[] unitDetails = new UnitDetails[userUnitsQuantity];

        unit.generateUnits(unitDetails, boardContent);
        target.targets(unitDetails);

        Move move = new Move();
        SuppliesUpdate suppliesUpdate = new SuppliesUpdate();

        MyFrame frame = new MyFrame(boardContent);
        //MyFrameInput fram2 = new MyFrameInput();
        System.out.println("koniec");
        TimeUnit.SECONDS.sleep(4);

        for (int i = 0; i < 100; i++) { //i liczba rund do symulowania
            target.targets(unitDetails);
            move.unitMove(boardContent, unitDetails);
            suppliesUpdate.update(unitDetails, boardContent);
        }

        TimeUnit.SECONDS.sleep(4);
        frame.update(frame.getGraphics());


        for (int i = 0; i < 5000; i++) {
            if (unitDetails[i].active) {
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

