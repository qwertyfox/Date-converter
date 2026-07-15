package com.qwertyfox.logictest;

import java.util.Arrays;
import java.util.List;

/**
 * Data Structure -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Adding 13 starting from index 2 sub element 3 should give final answer as index 5 sub element 1
 */
public class AddFromRandomPosition {

    private static List<Integer> configData = Arrays.asList(1001, 3, 4, 5, 6, 7);

    public static void main(String[] args) {
        System.out.println(addFromNonZeroIndexAndNonZeroSubPosition(2, 1, 9));
    }




    private static String addFromNonZeroIndexAndNonZeroSubPosition (int indexToAddFrom, int subElementToAddFrom, int numberToAdd) {
        // left over sum from indexToAddFrom
        int initialSum = configData.get(indexToAddFrom) - subElementToAddFrom;

        int elementSums = initialSum;
        int subElement;

        while(true) {

            // if the addition does not require to jump to the next index
            if(numberToAdd <= initialSum) {
                return "index: " + indexToAddFrom + " sub element: " + (subElementToAddFrom + numberToAdd);
            }

            // since we already know the total sum from indexToAddFrom (initialSum), the loop starts from + 1
            for(int index = indexToAddFrom +1 ; index < configData.size(); index ++ ) {
                elementSums += configData.get(index);
                if(elementSums >= numberToAdd) {
                    int value = configData.get(index);
                    int valueBeforeCurrentIndex = (elementSums - value);
                    subElement = numberToAdd - valueBeforeCurrentIndex;

                    return "index: " + index + " sub element: " + subElement;
                }
            }

        }


    }

}
