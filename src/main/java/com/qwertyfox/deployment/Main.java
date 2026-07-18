package com.qwertyfox.deployment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        ReadTxt readTxt = new ReadTxt();
        List<List<Integer>> d = readTxt.readTxt("data/Hooked.txt");
        System.out.println(d);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String hookDateString = "14/04/2026";
        LocalDate hookDate = LocalDate.parse(hookDateString, formatter);

        String testDateString = "06/06/2026";
        LocalDate testDate = LocalDate.parse(testDateString, formatter);

        long daysBetween = hookDate.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println(daysBetween);

        long daysBetweenTest = hookDate.until(testDate, ChronoUnit.DAYS);

        List<Integer> theList = d.get(0);
//        System.out.println(addingToDataStructure(theList, (int) daysBetween));
        System.out.println(addingToDataStructure(theList, (int) daysBetweenTest));

    }

    private static String addingToDataStructure (List<Integer> list ,int numberToAdd) {
        int elementSums = 0;
        int index = 1;
        int subElement;

        numberToAdd = numberToAdd +1;
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
