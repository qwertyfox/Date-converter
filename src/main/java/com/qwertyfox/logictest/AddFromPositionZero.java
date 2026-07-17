package com.qwertyfox.logictest;

import java.util.Arrays;
import java.util.List;

/**
 * Data Structure -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Adding 13 to this from contents of element 2 should give final answer as index 4 sub element 2
 */

public class AddFromPositionZero {

    private static List<Integer> configData = Arrays.asList(1001, 3, 4, 5, 6, 7);

    public static void main(String[] args) {
        addFromFirstElement();
    }

    public static void addFromFirstElement() {
        int valueToAdd = 6;
        System.out.println(addingToDataStructure(valueToAdd + 1)); // logical requirement
    }

    // should return index 4 sub element 2
    private static String addingToDataStructure (int numberToAdd) {
        int elementSums = 0;
        int index = 1;
        int subElement;


            for(index = 1; index < configData.size(); index ++) {
                elementSums += configData.get(index);
                if(elementSums > numberToAdd){
                    int value = configData.get(index); // getting the sum value of the current index
                    int valueBeforeCurrentIndex = (elementSums - value); // sum value before the current index value was added to the sum
                    subElement = numberToAdd - valueBeforeCurrentIndex; // the remaining is the sub element

                    // if the subElement value is 0, ie, the required sub element is at the end of the index then
                    if(subElement == 0) {
                        subElement = configData.get(index - 1);
                        index = index - 1;
                    }

                    return "index: " + index + " sub element: " + subElement;
                }
            }
            return "";
    }
}
