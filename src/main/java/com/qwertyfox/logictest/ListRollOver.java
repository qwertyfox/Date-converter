package com.qwertyfox.logictest;

import java.util.*;

/**
 * Data Structure a -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Data Structure b -> [1002, (1,2,3,4) (1,2,3,4,5) (1,2,3) (1,2,3,4) (1,2,3,4,5,6,7)]
 * Data Structure b -> [1002, (1,2,3) (1,2,3,4,5,6) (1,2,3) (1,2,3,4) (1,2,3,4,5,6)]
 */

public class ListRollOver {


    private static List<Integer> listA = Arrays.asList(1001, 3, 4, 5, 6, 7);
    private static List<Integer> listB = Arrays.asList(1002, 4, 5, 3, 4, 7);
    private static List<Integer> listC = Arrays.asList(1002, 3, 6, 3, 4, 6);


    private static List<List<Integer>> computationalList = new ArrayList<>();
    private static Map<Integer, Integer> mapWithListTotal = new HashMap<>();

    public static void main(String[] args) {

    }

    // will be done by the Buffered reader
    private static void addToMap () {

        computationalList.add(listA);
        computationalList.add(listB);
        computationalList.add(listC);
    }

    private static void calculateTotal() {
        for(List<Integer> list: computationalList){
            int listSum = 0;
            for(int i = 1; i <= list.size(); i ++) {
                listSum += list.get(i);
            }
            mapWithListTotal.put(list.get(0), listSum);
        }
    }

    private static void addToList (int indexToAddFrom, int subElementToAddFrom, int nonZeroPositionNumberToAdd) {

        int initialSum = listA.get(indexToAddFrom) - subElementToAddFrom;

        int elementSum = initialSum;
        int subElement;

        while (true) {
            // check if the total in the list a suffices to fulfil the numberToAdd criteria
        }


    }
}
