package com.qwertyfox.logictest;

import java.util.*;

/**
 * Data Structure list a -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Data Structure list b -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Data Structure list c -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Data Structure list d -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Data Structure list e -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 */

public class ListRollOver {

    private static List<Integer> hookList = Arrays.asList(1000, 5, 6, 7);
    private static List<Integer> listA = Arrays.asList(1001, 3, 4, 5, 6, 7);
    private static List<Integer> listB = Arrays.asList(1002, 3, 4, 5, 6, 7);
    private static List<Integer> listC = Arrays.asList(1003, 3, 4, 5, 6, 7);
    private static List<Integer> listD = Arrays.asList(1004, 3, 4, 5, 6, 7);
    private static List<Integer> listE = Arrays.asList(1005, 3, 4, 5, 6, 7);

    private static List<List<Integer>> listOfLists = new ArrayList<>();
    private static Map<Integer, List<Integer>> yearList = new HashMap<>();
    private static Map<Integer, Integer> mapWithListTotal = new HashMap<>();

    public static void main(String[] args) {
        addToMap();
        computeLists();

        System.out.println(mapWithListTotal);
        System.out.println(findList(44));
    }

    // will be done by the Buffered reader
    private static void addToMap () {
        listOfLists.add(hookList);
        listOfLists.add(listA);
        listOfLists.add(listB);
        listOfLists.add(listC);
        listOfLists.add(listD);
        listOfLists.add(listE);
    }

    private static void computeLists() {
        for(List<Integer> list: listOfLists){
            int listSum = 0;
            for(int i = 1; i < list.size(); i ++) {
                listSum += list.get(i);
            }
            mapWithListTotal.put(list.get(0), listSum);
            yearList.put(list.get(0), list);
        }
    }

    private static List<Integer> findList (int numberToAdd) {

        int firstEntry =  mapWithListTotal.keySet().iterator().next();
        int firstEntryTotal = mapWithListTotal.get(firstEntry);

        if(numberToAdd <= firstEntryTotal) {
            return yearList.get(firstEntry);
        }

        int total = 0;
        for(Map.Entry<Integer, Integer> entry : mapWithListTotal.entrySet()){
            total += entry.getValue();

            if(total >= numberToAdd) {
                return yearList.get(entry.getKey());
            }
        }

        return null;
    }


    private static void addToList (int indexToAddFrom, int subElementToAddFrom, int nonZeroPositionNumberToAdd) {

        int initialSum = listA.get(indexToAddFrom) - subElementToAddFrom;

        int elementSum = initialSum;
        int subElement;

        while (true) {


        }


    }
}
