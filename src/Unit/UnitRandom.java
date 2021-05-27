package Unit;

import Board.BoardContent;

import java.util.Random;

public class UnitRandom {
    Random random = new Random();

    protected void unitFill(UnitDetails[] unitDetails, BoardContent[][] boardContent, int i) {
        unitDetails[i].type = numberToName();
        unitDetails[i].hunger = random.nextInt(51) + 30; // procentowo głód
        unitDetails[i].stone = random.nextInt(51) + 30; // procentwo ilość kamienia
        unitDetails[i].iron = random.nextInt(51) + 30; // procentowo ilość żelaza
        unitDetails[i].wood = random.nextInt(51) + 30; // procentowo ilosc drewna
        unitDetails[i].quantity = random.nextInt(710) + 200; // liczebność grupy
        unitDetails[i].active = true;

        if (unitDetails[i].quantity >= 3000) {
            unitDetails[i].stationary = true;
        } else {
            unitDetails[i].stationary = false;
        }

        do {
            unitDetails[i].xPosition = random.nextInt(1000);
            unitDetails[i].yPosition = random.nextInt(1000);
        }
        while (boardContent[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied);
        boardContent[unitDetails[i].xPosition][unitDetails[i].yPosition].occupied = true;
        unitDetails[i].xScoutsPosition = unitDetails[i].xPosition;
        unitDetails[i].yScoutsPosition = unitDetails[i].yPosition;
    }

    private String numberToName() {
        int rnd;
        rnd = random.nextInt(5);
        switch (rnd) {
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
