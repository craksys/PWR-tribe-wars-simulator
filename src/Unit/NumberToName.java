package Unit;

import java.util.Random;

public class NumberToName {

    Random random = new Random();
    int number;

    public String change(){
        number = random.nextInt(8);
        switch (number){
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
            case 5 -> {
                return "Goblin";
            }
            case 6 -> {
                return "Gnom";
            }
            case 7 -> {
                return "Gigant";
            }
            default -> {
                return "Czlowiek";
            }
        }

    }
}
