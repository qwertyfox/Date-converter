package com.qwertyfox.logic;


import java.util.*;

/**                                                                                                 Cumulative sum
 * Data Structure hookList = [1000, (1,2,3,4,5) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]          18
 * Data Structure list a -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     43
 * Data Structure list b -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     68
 * Data Structure list c -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     93
 * Data Structure list d -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     118
 * Data Structure list e -> [1002, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]     143
 */

public class ListRollOver {

    private static List<Integer> hookList = Arrays.asList(1000, 5, 6, 7);
    private static List<Integer> listA = Arrays.asList(1001, 3, 4, 5, 6, 7);
    private static List<Integer> listB = Arrays.asList(1002, 3, 4, 5, 6, 7);
    private static List<Integer> listC = Arrays.asList(1003, 3, 4, 5, 6, 7);
    private static List<Integer> listD = Arrays.asList(1004, 3, 4, 5, 6, 7);
    private static List<Integer> listE = Arrays.asList(1005, 3, 4, 5, 6, 7);

    private static List<List<Integer>> listOfLists = new ArrayList<>();
    private static Map<Integer, List<Integer>> yearList = new LinkedHashMap<>();
    private static Map<Integer, Integer> mapWithListTotal = new LinkedHashMap<>();

    public static void main(String[] args) {
        addToMap();
        computeLists();

        System.out.println(mapWithListTotal);
        ListRollOverDataModel listRollOverDataModel;

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter value: ");
            int value = scanner.nextInt();

            listRollOverDataModel = findList(value);
            System.out.println(listRollOverDataModel.list);
            System.out.println(listRollOverDataModel.remainingJumps);
            System.out.println(addingToDataStructure(listRollOverDataModel.list, listRollOverDataModel.remainingJumps));

        }


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

    private static ListRollOverDataModel findList (int numberToAdd) {

        int previousTotal = 0;

        for(Map.Entry<Integer, Integer> entry : mapWithListTotal.entrySet()){
            int newTotal = previousTotal + entry.getValue();

            if(newTotal >= numberToAdd) {
                int leftOver = numberToAdd - previousTotal;
                return new ListRollOverDataModel(yearList.get(entry.getKey()), leftOver);
            }
            previousTotal = newTotal;
        }

        return null;
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
