package com.qwertyfox.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalendarInitializer {

    private String loc;

    private List<List<Integer>> listOfLists = new ArrayList<>();
    private final Map<Integer, List<Integer>> yearMap = new LinkedHashMap<>();
    private final Map<Integer, Integer> mapWithListTotal = new LinkedHashMap<>();
    private final Map<Integer, Integer> cumulativeSumMap = new LinkedHashMap<>();

    public CalendarInitializer(String loc) {
        listOfLists = load(loc);
        createMapWithTotal();
        createCumulativeSumMap();
    }

    public List<List<Integer>> getListOfLists() {
        return listOfLists;
    }

    public Map<Integer, List<Integer>> getYearMap() {
        return yearMap;
    }

    public Map<Integer, Integer> getMapWithListTotal() {
        return mapWithListTotal;
    }

    public Map<Integer, Integer> getCumulativeSumMap() {
        return cumulativeSumMap;
    }



    private List<List<Integer>> load(String loc) {
        List<List<Integer>> calandarList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(loc))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }

                String cleaned = line.replace("(", "").replace(")", "");
                String[] splits = cleaned.split(",");

                List<Integer> yearList = new ArrayList<>();

                for (String s : splits) {
                    yearList.add(Integer.parseInt(s.trim()));
                }

                calandarList.add(yearList);

            }
            return calandarList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    private void createMapWithTotal() {
        for (List<Integer> list : listOfLists) {
            int listSum = 0;
            for (int i = 1; i < list.size(); i++) {
                listSum += list.get(i);
            }
            mapWithListTotal.put(list.get(0), listSum);
            yearMap.put(list.get(0), list);
        }
    }


    private void createCumulativeSumMap() {
        int cumulativeSum = 0;

        for (Map.Entry<Integer, Integer> entry : mapWithListTotal.entrySet()) {
            int year = entry.getKey();
            cumulativeSum += entry.getValue();
            cumulativeSumMap.put(year, cumulativeSum);
        }
    }

}
