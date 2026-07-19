package com.qwertyfox.logic;

import java.util.*;

/**                                                                                                 Cumulative sum
 * Data Structure hookList = [1000, (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]                      18
 * Data Structure list a -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     43
 * Data Structure list b -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     68
 * Data Structure list c -> [1003, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     93
 * Data Structure list d -> [1004, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     118
 * Data Structure list e -> [1005, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     143
 */

public class AddToRandomPosition {

    private static List<Integer> hookList = Arrays.asList(1000, 5, 6, 7);
    private static List<Integer> listA = Arrays.asList(1001, 3, 4, 5, 6, 7);
    private static List<Integer> listB = Arrays.asList(1002, 3, 4, 5, 6, 7);
    private static List<Integer> listC = Arrays.asList(1003, 3, 4, 5, 6, 7);
    private static List<Integer> listD = Arrays.asList(1004, 3, 4, 5, 6, 7);
    private static List<Integer> listE = Arrays.asList(1005, 3, 4, 5, 6, 7);


    private static List<List<Integer>> listOfLists = new ArrayList<>();
    private static Map<Integer, List<Integer>> yearList = new LinkedHashMap<>();
    private static Map<Integer, Integer> mapWithListTotal = new LinkedHashMap<>();
    private static Map<Integer, Integer> cumulativeSumMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        addToMap();
        createMapWithTotal();
        createCumulativeSumMap();
        System.out.println("mapWithListTotal " +mapWithListTotal);
        System.out.println("yearList " +yearList);
        System.out.println("listOfLists " +listOfLists);
        System.out.println("cumulativeSumMap" + cumulativeSumMap);


        String date = "03/03/1001";
        findNumberOfDays(date);
    }

    private static void findNumberOfDays (String date) {

        String split[] = date.trim().split("/");
        String listString = split[2];
        int listName = Integer.parseInt(listString);
        int index = Integer.parseInt(split[1]);
        int subElement = Integer.parseInt(split[0]);

        int cumulativeNumber = cumulativeSumMap.get(listName - 1);


        List<Integer> yearL = yearList.get(listName);
        System.out.println(yearL);
        int listSum = 0;
        for(int i = 1; i <= index -1; i++) {
            listSum += yearL.get(i);
        }

        System.out.println("Cumulative sum: " + cumulativeNumber);
        System.out.println("ListSum: " + listSum);
        System.out.println("Total jumps required: " + (listSum + cumulativeNumber + subElement));
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

    private static void createMapWithTotal() {
        for(List<Integer> list: listOfLists){
            int listSum = 0;
            for(int i = 1; i < list.size(); i ++) {
                listSum += list.get(i);
            }
            mapWithListTotal.put(list.get(0), listSum);
            yearList.put(list.get(0), list);
        }
    }

    private static void createCumulativeSumMap () {
        int cumulativeSum = 0;

        for(Map.Entry<Integer, Integer> entry : mapWithListTotal.entrySet()) {
            int year = entry.getKey();
            cumulativeSum += entry.getValue();
            cumulativeSumMap.put(year, cumulativeSum);
        }
    }

    private static String addingToDataStructure (List<Integer> list ,int numberToAdd) {
        int elementSums = 0;
        int index = 1;
        int subElement;


        for(index = 1; index < list.size(); index ++) {
            elementSums += list.get(index);
            if(elementSums >= numberToAdd){
                int value = list.get(index); // getting the sum value of the current index
                int valueBeforeCurrentIndex = (elementSums - value); // sum value before the current index value was added to the sum
                subElement = numberToAdd - valueBeforeCurrentIndex; // the remaining is the sub element

                // if the subElement value is 0, ie, the required sub element is at the end of the index then
                if(subElement == 0) {
                    subElement = list.get(index - 1);
                    index = index - 1;
                }

                return "index: " + index + " sub element: " + subElement;
            }
        }
        return "";
    }

}
