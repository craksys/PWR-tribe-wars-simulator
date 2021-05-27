package Targeting;

import Board.ArrayOfPlaces;
import Unit.UnitDetails;

import java.util.ArrayList;

public class FindNearTarget {

    protected void findTargetAndWriteToTab(UnitDetails[] unitDetails, int i) {
        switch (unitDetails[i].targetType) {
            case 1 -> {
                unitDetails[i].xTarget = ArrayOfPlaces.xFood.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xFood, ArrayOfPlaces.yFood, unitDetails, i));
                unitDetails[i].yTarget = ArrayOfPlaces.yFood.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xFood, ArrayOfPlaces.yFood, unitDetails, i));
                unitDetails[i].targetActive = true;
            }
            case 2 -> {
                unitDetails[i].xTarget = ArrayOfPlaces.xWood.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xWood, ArrayOfPlaces.yWood, unitDetails, i));
                unitDetails[i].yTarget = ArrayOfPlaces.yWood.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xWood, ArrayOfPlaces.yWood, unitDetails, i));
                unitDetails[i].targetActive = true;
            }
            case 3 -> {
                unitDetails[i].xTarget = ArrayOfPlaces.xStone.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xStone, ArrayOfPlaces.yStone, unitDetails, i));
                unitDetails[i].yTarget = ArrayOfPlaces.yStone.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xStone, ArrayOfPlaces.yStone, unitDetails, i));
                unitDetails[i].targetActive = true;
            }
            case 4 -> {
                unitDetails[i].xTarget = ArrayOfPlaces.xIron.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xIron, ArrayOfPlaces.yIron, unitDetails, i));
                unitDetails[i].yTarget = ArrayOfPlaces.yIron.get(returnNumberOfNearestSupplies(ArrayOfPlaces.xIron, ArrayOfPlaces.yIron, unitDetails, i));
                unitDetails[i].targetActive = true;
            }
            default -> unitDetails[i].targetActive = false;
        }
    }


    private int returnNumberOfNearestSupplies(ArrayList<Integer> x_array, ArrayList<Integer> y_array, UnitDetails[] unit_details, int i) {
        double nearest = 10000000;
        int nearestArrayNumber = 0;
        double helper;
        for (int j = 0; j < x_array.size(); j++) {
            helper = Math.sqrt(Math.pow((x_array.get(j) - unit_details[i].xPosition), 2) + Math.pow((y_array.get(j) - unit_details[i].yPosition), 2));
            if (helper < nearest) {
                nearestArrayNumber = j;
                nearest = helper;
            }

        }
        return nearestArrayNumber;
    }

}


