package com.qwertyfox.deployment;

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

    private List<List<Integer>> dataList = new ArrayList<>();
    private Map<Integer, List<Integer>> yearList = new LinkedHashMap<>();
    private Map<Integer, Integer> mapWithListTotal =  new LinkedHashMap<>();

    public CalendarInitializer(String loc) {
        dataList = load(loc);
    }

    public List<List<Integer>> getDataList() {
        return dataList;
    }

    public Map<Integer, List<Integer>> getYearList() {
        return yearList;
    }

    public Map<Integer, Integer> getMapWithListTotal() {
        return mapWithListTotal;
    }

    private List<List<Integer>> load (String loc) {

        List<List<Integer>> calandarList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(loc))) {
            String line;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("#")) {
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

}
