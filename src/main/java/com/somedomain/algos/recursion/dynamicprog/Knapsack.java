package com.somedomain.algos.recursion.dynamicprog;

public class Knapsack {

    static int[][] memoizedTable = null;
    static int[][] bottomsUpTable = null;


    public static int chooseMaxValue(int[] weightArray, int[] valueArray, final int allowedWeight, final int arrayCounter) {
        int totalValue = 0;
        if (allowedWeight <= 0 || arrayCounter >= weightArray.length || allowedWeight < weightArray[arrayCounter]) {
            totalValue = 0;
        } else {
            int withSelection = valueArray[arrayCounter] + chooseMaxValue(weightArray, valueArray, allowedWeight - weightArray[arrayCounter], arrayCounter + 1);
            int withSkipping = chooseMaxValue(weightArray, valueArray, allowedWeight, arrayCounter + 1);
            totalValue = Math.max(withSelection, withSkipping);
            System.out.println("arrayCounter: " + arrayCounter + ", withSelection:" + withSelection + ", withSkipping:" + withSkipping + ", totalValue: " + totalValue);
        }
        return totalValue;

    }

    public static int memoizeMaxValue(int[] weightArray, int[] valueArray, final int allowedWeight, final int arrayCounter) {
        if (memoizedTable == null)
            memoizedTable = initTable(weightArray.length, allowedWeight);
        int totalValue = 0;
        int memoizedValue = memoizedTable[arrayCounter][allowedWeight];
        if (allowedWeight <= 0 || arrayCounter >= weightArray.length || allowedWeight < weightArray[arrayCounter]) {
            totalValue = 0;
        } else if (memoizedValue != 0) {
            totalValue = memoizedValue;
        } else {
            int withSelection = valueArray[arrayCounter] + memoizeMaxValue(weightArray, valueArray, allowedWeight - weightArray[arrayCounter], arrayCounter + 1);
            int withSkipping = memoizeMaxValue(weightArray, valueArray, allowedWeight, arrayCounter + 1);
            totalValue = Math.max(withSelection, withSkipping);
            memoizedTable[arrayCounter][allowedWeight] = totalValue;
        }
        return totalValue;
    }

    public static int tabulizeMaxValue(int[] weightArray, int[] valueArray, final int maxWeight) {
        if (bottomsUpTable == null)
            bottomsUpTable = initTable(weightArray.length, maxWeight);
        for (int index = 0; index <= weightArray.length; index++) {
            for (int weightCounter = 0; weightCounter <= maxWeight; weightCounter++) {
                if (index == 0 || weightCounter == 0) {
                    bottomsUpTable[index][weightCounter] = 0;
                } else if (weightArray[index - 1] <= weightCounter) {
                    bottomsUpTable[index][weightCounter] = Math.max(valueArray[index - 1] + bottomsUpTable[index - 1][weightCounter - weightArray[index - 1]],
                            bottomsUpTable[index - 1][weightCounter]);
                } else {
                    bottomsUpTable[index][weightCounter] = bottomsUpTable[index - 1][weightCounter];
                }
            }
        }

        return bottomsUpTable[weightArray.length][maxWeight];
    }

    private static int[][] initTable(final int index, final int maxWeight) {
        int[][] memoizedTable = new int[index + 1][maxWeight + 1];
        for (int indexCounter = 0; indexCounter <= index; indexCounter++) {
            memoizedTable[indexCounter] = new int[maxWeight + 1];
            for (int weightCounter = 0; weightCounter <= maxWeight; weightCounter++) {
                memoizedTable[indexCounter][weightCounter] = 0;
            }
        }
        return memoizedTable;

    }
}