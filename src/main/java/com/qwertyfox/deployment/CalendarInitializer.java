package com.qwertyfox.deployment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CalendarInitializer {

    private static CalendarInitializer INSTANCE = new CalendarInitializer();

    public static CalendarInitializer getINSTANCE() {
        return INSTANCE;
    }

    private CalendarInitializer() {
    }


    public List<List<Integer>> readTxt(String loc) {

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
