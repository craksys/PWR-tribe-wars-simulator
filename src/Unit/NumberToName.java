package Unit;

import java.util.Random;

public class NumberToName {

    Random random = new Random();
    int number;

    public String change() {
        number = random.nextInt(5);
        switch (number) {
            case 0 -> {
                return "Czlowiek";
            }
            case 1 -> {
                return "Elf";
            }
            case 2 -> {
                return "Krasnolud";
            }
            case 3 -> {
                return "Ork";
            }
            case 4 -> {
                return "Troll";
            }
            default -> {
                return "Czlowiek";
            }
        }

    }
}
