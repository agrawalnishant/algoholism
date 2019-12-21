package com.somedomain.ds;

import com.google.common.flogger.FluentLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapArrayTo2dTree<T> {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public void print(List<T> heapAsArray, Integer currentSize) {
        ArrayList<ArrayList<T>> levelwiseList = new ArrayList<ArrayList<T>>();
        int maxLevels = Double.valueOf((Math.log(currentSize) / Math.log(2))).intValue();
        logger.atFinest().log("Depth of Heap: " + maxLevels);
        int startingIndex = 0;
        int elemCounter = 0;
        for (int counter = 0; counter <= maxLevels; counter++) {
            int maxElements = Double.valueOf(Math.pow(2, counter)).intValue();
            ArrayList<T> list = new ArrayList<>();
            for (int elemAtLevel = 0; elemCounter < currentSize && elemAtLevel < maxElements; elemAtLevel++) {
                if (counter == 0) {
                    startingIndex = 0;
                } else {
                    startingIndex = Double.valueOf(Math.pow(2, counter - 1)).intValue();
                }

                //logger.atFinest().log("startingIndex: " + startingIndex + ", elemAtLevel: " + elemAtLevel + ", elemCounter: " + elemCounter);
                if (elemCounter < currentSize) {
                    list.add(heapAsArray.get(elemCounter++));
                }
            }
            logger.atFinest().log("Elements at level " + (counter) + " are: " + Arrays.toString(list.toArray()));
            levelwiseList.add(list);
        }

    }
}
