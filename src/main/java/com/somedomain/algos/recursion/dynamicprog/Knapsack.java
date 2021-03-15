package com.somedomain.algos.recursion.dynamicprog;

public class Knapsack {

    static int[][] memoizedTable = null;


    public static int chooseMaxValue(int[] weightArray, int[] valueArray, final int allowedWeight, final int arrayCounter) {
        int totalValue = 0;
        //System.out.println("arrayCounter: " + arrayCounter);
        if (allowedWeight <= 0 || arrayCounter >= weightArray.length || allowedWeight < weightArray[arrayCounter]) {
            totalValue = 0;
            // System.out.println("totalValue: " + totalValue);
        } else {
            int withSelection = valueArray[arrayCounter] + chooseMaxValue(weightArray, valueArray, allowedWeight - weightArray[arrayCounter], arrayCounter + 1);
            int withSkipping = chooseMaxValue(weightArray, valueArray, allowedWeight, arrayCounter + 1);
            totalValue = Math.max(withSelection, withSkipping);
            System.out.println("arrayCounter: " + arrayCounter + ", withSelection:" + withSelection + ", withSkipping:" + withSkipping + ", totalValue: " + totalValue);
        }
        System.out.println("arrayCounter: " + arrayCounter + ", totalValue: " + totalValue);

        return totalValue;

    }

    public static int memoizeMaxValue(int[] weightArray, int[] valueArray, final int allowedWeight, final int arrayCounter) {
        initTable(weightArray.length, allowedWeight);
        int totalValue = 0;
        int memoizedValue = memoizedTable[arrayCounter][allowedWeight];
        if (allowedWeight <= 0 || arrayCounter >= weightArray.length || allowedWeight < weightArray[arrayCounter]) {
            totalValue = 0;
        } else if (memoizedValue != -1) {
            totalValue = memoizedValue;
        } else {
            int withSelection = valueArray[arrayCounter] + chooseMaxValue(weightArray, valueArray, allowedWeight - weightArray[arrayCounter], arrayCounter + 1);
            int withSkipping = chooseMaxValue(weightArray, valueArray, allowedWeight, arrayCounter + 1);
            totalValue = Math.max(withSelection, withSkipping);
            memoizedTable[arrayCounter][allowedWeight] = totalValue;
        }
        return totalValue;

    }

    private static void initTable(final int index, final int maxWeight) {

        if (memoizedTable == null) {
            memoizedTable = new int[index + 1][maxWeight + 1];
            for (int indexCounter = 0; indexCounter <= index; indexCounter++) {
                memoizedTable[indexCounter] = new int[maxWeight + 1];
                for (int weightCounter = 0; weightCounter <= maxWeight; weightCounter++) {
                    memoizedTable[indexCounter][weightCounter] = -1;
                }
            }
        }
    }
}
