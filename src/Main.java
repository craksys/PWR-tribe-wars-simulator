import Board.*;
import Graph.MyFrame;
import Graph.MyFrameInput;
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
        MyFrameInput fram2 = new MyFrameInput();
        while(!fram2.buttonclicked){TimeUnit.MILLISECONDS.sleep(30);}// oczekuj na wpisanie danych
        Unit unit = new Unit();
        Target target = new Target();


        Stats.alive = fram2.quantity;


        BoardContent[][] boardContent = new BoardContent[1000][1000];
        Board board = new Board(boardContent);
        board.createMap(boardContent);

        board.placeSupplies(boardContent, ArrayOfPlaces.xFood, ArrayOfPlaces.yFood, fram2.food, 1); //żywność
        board.placeSupplies(boardContent, ArrayOfPlaces.xWood, ArrayOfPlaces.yWood, fram2.wood, 2); // drewno
        board.placeSupplies(boardContent, ArrayOfPlaces.xStone, ArrayOfPlaces.yStone, fram2.stone, 3); //kamień
        board.placeSupplies(boardContent, ArrayOfPlaces.xIron, ArrayOfPlaces.yIron, fram2.iron, 4); //żelazo

        UnitDetails[] unitDetails = new UnitDetails[fram2.quantity];

        unit.generateUnits(unitDetails, boardContent);
        target.targets(unitDetails);

        Move move = new Move();
        SuppliesUpdate suppliesUpdate = new SuppliesUpdate();
        MyFrame frame = new MyFrame(boardContent,unitDetails);

        TimeUnit.SECONDS.sleep(3);

        for (int i = 0; i < fram2.rounds; i++) { //i liczba rund do symulowania
            suppliesUpdate.update(unitDetails, boardContent);
            target.targets(unitDetails);
            move.unitMove(boardContent, unitDetails, fram2.speed);
            if(i%10 == 0 && i!=0){
                frame.update(frame.getGraphics());
                TimeUnit.SECONDS.sleep(1);
            }
            Stats.rounds++;
        }
        frame.update(frame.getGraphics());

        int help=0;
        for(int z=0;z<unitDetails.length;z++)
        {if(unitDetails[z].active) help++;
        }

        System.out.println("Tyle sojuszy nawiązano: " + Stats.allays);
        System.out.println("Tyle żywych jednostek: " + Stats.alive + " a tyle naprawde zyje: " + help); //ile w tablicy alive
        System.out.println("Tyle interakcji: " + Stats.test);
        System.out.println("Tyle walk z remisem: " + Stats.test2);
        System.out.println("Tyle umarło z głodu: "+Stats.hungerdead);
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.write();


    }
}

