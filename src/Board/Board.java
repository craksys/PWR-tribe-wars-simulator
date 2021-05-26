package Board;


import java.util.ArrayList;

public class Board {
    BoardContent[][] boardContent;

    public Board(BoardContent[][] boardContent) {
        this.boardContent = boardContent;
    }


    LocateSources locatesources = new LocateSources();

    public void createMap(BoardContent[][] boardContent) {
        for (int i = 0; i < 1000; i++) {
            for (int k = 0; k < 1000; k++) {
                boardContent[i][k] = new BoardContent();
            }
        }
    }

    public void placeSupplies(BoardContent[][] boardContent, ArrayList<Integer> xArray, ArrayList<Integer> yArray, int amountOfSupplies, int typeOfSupplies) {
        locatesources.randSupplies(boardContent, amountOfSupplies, typeOfSupplies, xArray, yArray);
    }
}

