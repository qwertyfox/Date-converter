package com.qwertyfox.logictest;

import java.util.Arrays;
import java.util.List;

/**
 * Data Structure a -> [1001, (1,2,3) (1,2,3,4) (1,2,3,4,5) (1,2,3,4,5,6) (1,2,3,4,5,6,7)]
 * Data Structure b -> [1002, (1,2,3,4) (1,2,3,4,5) (1,2,3) (1,2,3,4) (1,2,3,4,5,6,7)]
 * Adding 26 to data structure a from a's index 3 sub element 2 should give final answer as list b index 3 sub element 1
 */

public class ListRollOver {


    private static List<Integer> a = Arrays.asList(1001, 3, 4, 5, 6, 7);
    private static List<Integer> b = Arrays.asList(1002, 4, 5, 3, 4, 7);

    private static void addToList (int indexToAddFrom, int subElementToAddFrom, int nonZeroPositionNumberToAdd) {

        int initialSum = a.get(indexToAddFrom) - subElementToAddFrom;

        int elementSum = initialSum;
        int subElement;

        while (true) {
            // check if the total in the list a suffices to fulfil the numberToAdd criteria
        }


    }
}
