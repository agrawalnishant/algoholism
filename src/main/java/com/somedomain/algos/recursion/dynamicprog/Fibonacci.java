package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;

public class Fibonacci {

    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();

    private static int[] memoizedTable = new int[100];

    public static void main(String[] args) {
        flogger.atInfo().log("Nth num: " + generateNthNum(6));
    }

    public static int generateNthNum(final int n) {
        int num = 0;
        if (n <= 1) {
            num = n;
        } else {
            num = generateNthNum(n - 1) + generateNthNum(n - 2);
        }
        return num;
    }

    public static int generateNthNumWithMemoization(final int n) {
        int num = 0;
        if (n <= 1) {
            num = n;
        } else if (memoizedTable[n] != 0) {
            num = memoizedTable[n];
        } else {
            num = generateNthNumWithMemoization(n - 1) + generateNthNumWithMemoization(n - 2);
            memoizedTable[n] = num;
        }
        return num;
    }

    public static int generateNthNumBottomsUpOptimally(final int n) {
        int num = 0;
        int lastNum = 0;
        int secondLastNum = 1;
        num = lastNum + secondLastNum;
        for (int counter = 1; counter <= n; counter++) {
            num = lastNum + secondLastNum;
            secondLastNum = lastNum;
            lastNum = num;
        }
        return num;
    }
}
