package com.qwertyfox.logic;

import java.util.ArrayList;
import java.util.List;


public class ListRollOverDataModel {

    List<Integer> list = new ArrayList<>();
    int remainingJumps;

    public ListRollOverDataModel(List<Integer> list, int remainingJumps) {
        this.list = list;
        this.remainingJumps = remainingJumps;
    }

}
