package Board;

import java.util.ArrayList;
import java.util.Random;

public class LocateSources {

    Random random = new Random();

    protected void randSupplies(BoardContent[][] boardContent, int amountOfSupplies, int typeOfSupplies, ArrayList<Integer> xArray, ArrayList<Integer> yArray) {
        for (int i = 0; i < amountOfSupplies; i++) {
            int x;
            int y;
            do {
                x = random.nextInt(1000);
                y = random.nextInt(1000);
            }
            while (boardContent[x][y].type != 0);

            boardContent[x][y].type = typeOfSupplies;
            xArray.add(x);
            yArray.add(y);
        }
    }
}
