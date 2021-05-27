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

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        MyFrameInput fram2 = new MyFrameInput();

        while(!fram2.buttonclicked){TimeUnit.MILLISECONDS.sleep(30);}// oczekuj na wpisanie danych
        Stats.alive = fram2.quantity; // ustawienie ilosci zywych jednostek na ilosc podana przez uzytkownika

        Unit unit = new Unit();
        Target target = new Target();
        BoardContent[][] boardContent = new BoardContent[1000][1000];// stworzenie mapy 1000x1000
        Board board = new Board(boardContent);
        board.createMap(boardContent); // stworzenie mapy

        board.placeSupplies(boardContent, ArrayOfPlaces.xFood, ArrayOfPlaces.yFood, fram2.food, 1); //wygenerowanie zywnosci na mapie
        board.placeSupplies(boardContent, ArrayOfPlaces.xWood, ArrayOfPlaces.yWood, fram2.wood, 2); // wygenerowanie drewna na mapie
        board.placeSupplies(boardContent, ArrayOfPlaces.xStone, ArrayOfPlaces.yStone, fram2.stone, 3); //wygenerowanie kamienia na mapie
        board.placeSupplies(boardContent, ArrayOfPlaces.xIron, ArrayOfPlaces.yIron, fram2.iron, 4); //wygenerowanie zelaza na mapie

        UnitDetails[] unitDetails = new UnitDetails[fram2.quantity]; // stworzenie tylu jednostek ile wprowadzil uzytkownik

        unit.generateUnits(unitDetails, boardContent); // wygenerowanie jednostek wraz ze statystykami

        Move move = new Move();
        SuppliesUpdate suppliesUpdate = new SuppliesUpdate();
        MyFrame frame = new MyFrame(boardContent,unitDetails); // wygenerowanie mapy na GUI
        WriteToFile writeToFile = new WriteToFile();
        File file = new File("src/Resources/Dane.csv");
        file.delete(); // usuniecie wczesniejszych danych

        TimeUnit.SECONDS.sleep(2);

        writeToFile.writeDataToFile(); // zapis statystyk na poczatku symulacji
        for (int i = 0; i < fram2.rounds; i++) { //petla do symulacji
            target.targets(unitDetails); // ustawienie celu dla jednostek
            move.unitMove(boardContent, unitDetails, fram2.speed); // sekwencja poruszania sie i interakcji
            suppliesUpdate.update(unitDetails, boardContent); // odwiezenie stanu zasobow jednostek
            if(i% fram2.refresh == 0 && i!=0){ // odswiezenie mapy i zapis do pliku po ilosci rund okreslonej przez uzytkownika
                frame.update(frame.getGraphics()); //odswiezenie mapy
                TimeUnit.SECONDS.sleep(1);
                writeToFile.writeDataToFile(); // zapis statystyk dla aktualnej rundy
            }
            Stats.rounds++; //ilosc przesymulowanych rund wyswietlany na GUI
        }
        frame.update(frame.getGraphics()); //odswiezenie mapy na ostatnia klatke symulacji
        writeToFile.writeDataToFile(); // zapis statystyk na koniec symulacji
    }

}

