package com.qwertyfox.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Converts BS to AD
 */

public class BStoAD_demo {

    static CalendarInitializer calendarInitializer = new CalendarInitializer("data/Dataset.txt");

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static Map<Integer, List<Integer>> yearMap =  calendarInitializer.getYearMap();
    static Map<Integer, Integer> mapWithListTotal = calendarInitializer.getMapWithListTotal();
    static Map<Integer, Integer> cumulativeSumMap = calendarInitializer.getCumulativeSumMap();

    public static void main(String[] args) {

        String date;
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.print("Enter Bikram Sambhat: ");
            date = scanner.nextLine();

            int requiredJumps = findNumberOfDays(date);
            LocalDate AD_Date = LocalDate.of(1993, 4, 13).plusDays(requiredJumps - 1);
            System.out.println(formatter.format(AD_Date));
        }


    }

    private static int findNumberOfDays (String date) {

        String split[] = date.trim().split("/");
        String listString = split[2];
        int listName = Integer.parseInt(listString);
        int index = Integer.parseInt(split[1]);
        int subElement = Integer.parseInt(split[0]);

        int cumulativeNumber = cumulativeSumMap.get(listName - 1);

        List<Integer> yearL = yearMap.get(listName);
        System.out.println(yearL);
        int listSum = 0;
        for(int i = 1; i <= index -1; i++) {
            listSum += yearL.get(i);
        }

        int totalJumpsRequired = (listSum + cumulativeNumber + subElement);
        System.out.println("Cumulative sum: " + cumulativeNumber);
        System.out.println("ListSum: " + listSum);
        System.out.println("Total jumps required: " + totalJumpsRequired);

        return totalJumpsRequired;
    }


}
