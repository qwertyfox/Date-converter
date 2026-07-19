package com.qwertyfox.hooks;

import com.qwertyfox.logic.ListRollOverDataModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hook1990BS {

    static CalendarInitializer calendarInitializer = new CalendarInitializer("data/Dataset.txt");

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static Map<Integer, List<Integer>> yearList =  calendarInitializer.getYearList();
    static Map<Integer, Integer> mapWithListTotal = calendarInitializer.getMapWithListTotal();

    public static void main(String[] args) {

        String hookDateString = "13/04/1993"; // 1st Baishak 2050
        LocalDate hookDate = convertToLocalDate(hookDateString);

        ListRollOverDataModel listRollOverDataModel;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Enter AD date: ");
            String date = scanner.nextLine();

            LocalDate testDate = convertToLocalDate(date);

            long daysBetweenTest = hookDate.until(testDate, ChronoUnit.DAYS);

            listRollOverDataModel= findList((int) daysBetweenTest);
            System.out.println(listRollOverDataModel.getList());
            System.out.println(listRollOverDataModel.getRemainingJumps());
            System.out.println(addingToDataStructure(listRollOverDataModel.getList(), listRollOverDataModel.getRemainingJumps()));

        }

    }

    private static LocalDate convertToLocalDate (String date) {
        return LocalDate.parse(date, formatter);
    }

    private static String addingToDataStructure(List<Integer> list, int numberToAdd) {
        int elementSums = 0;
        int index = 1;
        int subElement;

        numberToAdd = numberToAdd + 1;
        for (index = 1; index < list.size(); index++) {
            elementSums += list.get(index);
            if (elementSums >= numberToAdd) {
                int value = list.get(index); // getting the sum value of the current index
                int valueBeforeCurrentIndex = (elementSums - value); // sum value before the current index value was added to the sum
                subElement = numberToAdd - valueBeforeCurrentIndex; // the remaining is the sub element

                // if the subElement value is 0, ie, the required sub element is at the end of the index then
                if (subElement == 0) {
                    subElement = list.get(index - 1);
                    index = index - 1;
                }

                return "index: " + index + " sub element: " + subElement;
            }
        }
        return "";
    }

    private static ListRollOverDataModel findList(int numberToAdd) {

        int previousTotal = 0;

        for (Map.Entry<Integer, Integer> entry : mapWithListTotal.entrySet()) {
            int newTotal = previousTotal + entry.getValue();

            if (newTotal >= numberToAdd) {
                int leftOver = numberToAdd - previousTotal;
                return new ListRollOverDataModel(yearList.get(entry.getKey()), leftOver);
            }
            previousTotal = newTotal;
        }

        return null;
    }

}
