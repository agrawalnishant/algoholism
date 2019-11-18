package com.somedomain.algos.arraysandstring;

import java.util.ArrayList;

public class RotateArray {

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> sourceArr, int positions) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int newSize = 0;
        if (positions > sourceArr.size()) {
            newSize = positions % sourceArr.size();
        }
        for (int i = 0; i < sourceArr.size() - newSize; i++) {
            ret.add(sourceArr.get(i + newSize));
        }
        for (int i = 0; i < newSize; i++) {
            ret.add(sourceArr.get(i));
        }
        return ret;
    }
}
