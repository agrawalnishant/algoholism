package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.Utility;

import java.util.concurrent.atomic.AtomicInteger;

public class SmallestCommonSuperSequence {

    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();


    public static String findSCSNaive(final String s1, final String s2) {
        AtomicInteger calculationCount = new AtomicInteger(0);

        int idx = findSCSIndexNaive(s1, s2, 0, 0, 0, calculationCount);
        flogger.atInfo().log("Max Calculations in Naive Model:" + calculationCount.get());

        return s1.concat(idx == 0 ? s2 : s2.substring(idx));

    }

    private static int findSCSIndexNaive(String s1, String s2, int idx1, int idx2, int count, AtomicInteger calculationCount) {
        if (idx1 >= s1.length() - 1 || idx2 >= s2.length() - 1) {
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                return count + 1;
            } else {
                return 0;
            }
        }
        int count1 = 0, count2 = 0;
        calculationCount.incrementAndGet();
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            count1 = findSCSIndexNaive(s1, s2, idx1 + 1, idx2 + 1, count + 1, calculationCount);
        }
        count2 = findSCSIndexNaive(s1, s2, idx1 + 1, 0, 0, calculationCount);
        return Math.max(count1, count2);


    }


    public static String findSCSMemoized(final String s1, final String s2) {
        AtomicInteger calculationCount = new AtomicInteger(0);
        int[][] lookupTable = Utility.buildAndInit2DMatrix(s1.length(), s2.length(), -1);
        int idx = findSCSIndexMemoized(s1, s2, 0, 0, 0, lookupTable, calculationCount);
        flogger.atInfo().log("Max Calculations in Naive Model:" + calculationCount.get());
        return s1.concat(idx == 0 ? s2 : s2.substring(idx));
    }

    private static int findSCSIndexMemoized(String s1, String s2, int idx1, int idx2, int count, int[][] lookupTable, AtomicInteger calculationCount) {
        if (idx1 >= s1.length() - 1 || idx2 >= s2.length() - 1) {
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                return count + 1;
            } else {
                return 0;
            }
        }
        if (lookupTable[idx1][idx2] != -1) {
            return lookupTable[idx1][idx2];
        }
        int count1 = 0, count2 = 0;
        calculationCount.incrementAndGet();
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            count1 = findSCSIndexMemoized(s1, s2, idx1 + 1, idx2 + 1, count + 1, lookupTable, calculationCount);
        }
        count2 = findSCSIndexMemoized(s1, s2, idx1 + 1, 0, 0, lookupTable, calculationCount);
        lookupTable[idx1][idx2] = Math.max(count1, count2);
        return lookupTable[idx1][idx2];

    }


}
