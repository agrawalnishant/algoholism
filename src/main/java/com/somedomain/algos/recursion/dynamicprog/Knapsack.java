package com.somedomain.algos.recursion.dynamicprog;

public class Knapsack {


    public static int chooseMaxValue(int[] weightArray, int[] valueArray, final int allowedWeight, final int arrayCounter) {
        int totalValue = 0;
        if (allowedWeight <= 0 || arrayCounter >= weightArray.length || allowedWeight < weightArray[arrayCounter]) {
            totalValue = 0;
        } else {
            int withSelection = valueArray[arrayCounter] + chooseMaxValue(weightArray, valueArray, allowedWeight - weightArray[arrayCounter], arrayCounter + 1);
            int withSkipping = chooseMaxValue(weightArray, valueArray, allowedWeight, arrayCounter + 1);
            totalValue = Math.max(withSelection, withSkipping);
        }
        return totalValue;

    }
}
