package com.qwertyfox.deployment;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadTxt readTxt = new ReadTxt();
        List<List<Integer>> d = readTxt.readTxt("data/Hooked.txt");
        System.out.println(d);
    }

}
