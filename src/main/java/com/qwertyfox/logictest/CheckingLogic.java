package com.qwertyfox.logictest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckingLogic {

    public void doSomething() {

        List<Integer> configData = Arrays.asList(1001, 3, 4, 5, 6, 7);

        // Data Structure -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
        int valueToAdd = 13;

        // adding config data as data structure
        List<List<Integer>> dataStructure = addNumbersFromConfigData(configData);


    }

    private List<List<Integer>> addNumbersFromConfigData (List<Integer> configData) {
        List<List<Integer>> dataStructure = new ArrayList<>();
        dataStructure.add(Arrays.asList(configData.get(0))); // cause the first element is the year

        for(int i = 1; i >= configData.size() -1; i ++) {
            // reading the config data
            int numbersInMiniList = configData.get(i);

            List<Integer> miniList = new ArrayList<>();
            // adding the elements in miniList based on numbersInMiniList
            for(int j = 1; j >= numbersInMiniList; j++) {
                miniList.add(j);
            }
            dataStructure.add(miniList);
        }
        return dataStructure;
    }

}
