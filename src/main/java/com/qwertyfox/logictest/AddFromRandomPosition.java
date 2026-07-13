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
        System.out.println(addFromNonZero(2, 3, 12));
    }


    private static String addFromNonZero (int indexToAddFrom, int subElementToAddFrom, int nonZeroPositionNumberToAdd) {
        // left over sum from indexToAddFrom
        int initialSum = configData.get(indexToAddFrom) - subElementToAddFrom;

        int index = indexToAddFrom;

        int elementSums = initialSum;
        int subElement;

        while(true) {
            // since we already know the total sum from indexToAddFrom (initialSum), the loop starts from + 1
            for(index = indexToAddFrom +1 ; index < configData.size(); index ++ ) {
                elementSums += configData.get(index);
                if(elementSums > nonZeroPositionNumberToAdd) {
                    int value = configData.get(index);
                    int valueBeforeCurrentIndex = (elementSums - value);
                    subElement = nonZeroPositionNumberToAdd - valueBeforeCurrentIndex;

                    if(subElement == 0) {
                        subElement = configData.get(index - 1);
                        index = index - 1;
                    }
                    return "index: " + index + " sub element: " + subElement;
                }
            }

        }


    }

}
