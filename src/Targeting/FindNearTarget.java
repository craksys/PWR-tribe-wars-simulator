package Targeting;

import Board.ArrayOfPlaces;
import Unit.Unit_Details;

import java.util.ArrayList;

public class FindNearTarget {

    public void findtargetandwritetotab(Unit_Details[] unit_details, int i) {
        switch (unit_details[i].targettype) {
            case 1 -> {
                unit_details[i].x_target = ArrayOfPlaces.x_food.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_food, ArrayOfPlaces.y_food, unit_details, i));
                unit_details[i].y_target = ArrayOfPlaces.y_food.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_food, ArrayOfPlaces.y_food, unit_details, i));
                unit_details[i].targetactive = true;
            }
            case 2 -> {
                unit_details[i].x_target = ArrayOfPlaces.x_wood.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_wood, ArrayOfPlaces.y_wood, unit_details, i));
                unit_details[i].y_target = ArrayOfPlaces.y_wood.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_wood, ArrayOfPlaces.y_wood, unit_details, i));
                unit_details[i].targetactive = true;
            }
            case 3 -> {
                unit_details[i].x_target = ArrayOfPlaces.x_stone.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_stone, ArrayOfPlaces.y_stone, unit_details, i));
                unit_details[i].y_target = ArrayOfPlaces.y_stone.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_stone, ArrayOfPlaces.y_stone, unit_details, i));
                unit_details[i].targetactive = true;
            }
            case 4 -> {
                unit_details[i].x_target = ArrayOfPlaces.x_iron.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_iron, ArrayOfPlaces.y_iron, unit_details, i));
                unit_details[i].y_target = ArrayOfPlaces.y_iron.get(returnnumberofnearestsupplies(ArrayOfPlaces.x_iron, ArrayOfPlaces.y_iron, unit_details, i));
                unit_details[i].targetactive = true;
            }
            default -> {
                unit_details[i].targetactive = false;
            }
        }
    }


    private int returnnumberofnearestsupplies(ArrayList<Integer> x_array, ArrayList<Integer> y_array, Unit_Details[] unit_details, int i) {
        double nearest = 10000000;
        int nearest_arraynumber = 0;
        double helper;
        for (int j = 0; j < x_array.size(); j++) {
            helper = Math.sqrt(Math.pow((x_array.get(j) - unit_details[i].x_position), 2) + Math.pow((y_array.get(j) - unit_details[i].y_position), 2));
            if (helper < nearest) {
                nearest_arraynumber = j;
                nearest = helper;
            }

        }
        return nearest_arraynumber;

    }

}


