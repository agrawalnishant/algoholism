package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;

public class Fibonacci {

    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        flogger.atInfo().log("Nth num: " + generateWithoutMemoization(6));
    }

    public static int generateWithoutMemoization(final int n) {
        int num = 0;
         if (n <= 1) {
            num = n;
        } else {
            num = generateWithoutMemoization(n - 1) + generateWithoutMemoization(n - 2);
        }
        return num;
    }
}
