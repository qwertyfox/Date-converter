package com.qwertyfox.logictest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Data Structure -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Adding 13 to this from contents of element 2 should give final answer as index 4 sub element 2
 */

public class CheckingLogic {

//    private static List<List<Integer>> dataStructure = new ArrayList<>();
    private static List<Integer> configData = Arrays.asList(1001, 3, 4, 5, 6, 7);

    public static void main(String[] args) {
        doSomething();
    }

    public static void doSomething() {

        // Data Structure -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
        int valueToAdd = 13;

        // adding config data as data structure
//        dataStructure = addNumbersFromConfigData(configData);
        System.out.println(addingToDataStructure(valueToAdd +1));

    }

//    private static List<List<Integer>> addNumbersFromConfigData (List<Integer> configData) {
//        List<List<Integer>> dataStructure = new ArrayList<>();
//        dataStructure.add(Arrays.asList(configData.get(0))); // cause the first element is the year
//
//        for(int i = 1; i < configData.size(); i ++) {
//            // reading the config data
//            int numbersInMiniList = configData.get(i);
//
//            List<Integer> miniList = new ArrayList<>();
//            // adding the elements in miniList based on numbersInMiniList
//            for(int j = 1; j >= numbersInMiniList; j++) {
//                miniList.add(j);
//            }
//            dataStructure.add(miniList);
//        }
//        return dataStructure;
//    }

    // should return index 4 sub element 2
    private static String addingToDataStructure (int numberToAdd) {
        int elementSums = 0;
        int index = 1;
        int subElement;

        while(true) {

            for(index = 1; index < configData.size(); index ++) {
                elementSums += configData.get(index);
                if(elementSums > numberToAdd){
                    int value = configData.get(index);
                    int valueBeforeCurrentIndex = (elementSums - value);
                    subElement = numberToAdd - valueBeforeCurrentIndex;
                    return "index: " + index + " sub element: " + subElement;
                }
            }
        }
    }

}
