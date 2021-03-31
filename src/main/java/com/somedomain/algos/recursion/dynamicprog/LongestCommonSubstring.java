package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.Utility;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestCommonSubstring {
    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();


    public static int maxLengthNaive(final String firstString, final String secondString) {
        if (firstString == null || firstString.length() == 0 || secondString == null || secondString.length() == 0) {
            return 0;
        } else {
            AtomicInteger calculationCount = new AtomicInteger(0);
            int maxCommLength = maxLengthNaive(firstString.toLowerCase().toCharArray(), 0, secondString.toLowerCase().toCharArray(), 0, 0, calculationCount);
            flogger.atInfo().log("Max Calculations in Naive Model:" + calculationCount.get());
            return maxCommLength;
        }
    }

    private static int maxLengthNaive(final char[] firstString, final int idxFirst, final char[] secondString, final int idxSecond, int maxCommLen, AtomicInteger calculationCount) {
        int count2 = 0, count3 = 0;

        if (idxFirst >= firstString.length || idxSecond >= secondString.length) {
            return maxCommLen;
        }
        calculationCount.incrementAndGet();
        if (firstString[idxFirst] == secondString[idxSecond]) {
            maxCommLen = maxLengthNaive(firstString, idxFirst + 1, secondString, idxSecond + 1, maxCommLen + 1, calculationCount);
        }
        count2 = maxLengthNaive(firstString, idxFirst, secondString, idxSecond + 1, 0, calculationCount);
        count3 = maxLengthNaive(firstString, idxFirst + 1, secondString, idxSecond, 0, calculationCount);
        maxCommLen = Math.max(maxCommLen, Math.max(count2, count3));
        return maxCommLen;
    }

    public static int maxLengthMemoized(final String firstString, final String secondString) {
        if (firstString == null || firstString.length() == 0 || secondString == null || secondString.length() == 0) {
            return 0;
        } else {
            AtomicInteger calculationCount = new AtomicInteger(0);
            int[][][] max_length_matrix = Utility.buildAndInit3DMatrix(firstString.length(), secondString.length(), 100, -1);
            int maxCommLength = maxLengthMemoized(firstString.toLowerCase().toCharArray(), 0, secondString.toLowerCase().toCharArray(), 0, 0, max_length_matrix, calculationCount);
            flogger.atInfo().log("Max Calculations in Memoized Model:" + calculationCount.get());
            return maxCommLength;
        }
    }

    private static int maxLengthMemoized(final char[] firstString, final int idxFirst, final char[] secondString, final int idxSecond, int maxCommLen, int[][][] max_length_matrix, AtomicInteger calculationCount) {
        int count1 = maxCommLen, count2 = 0, count3 = 0;

        if (idxFirst >= firstString.length || idxSecond >= secondString.length) {
            return maxCommLen;
        }
        if (max_length_matrix[idxFirst][idxSecond][maxCommLen] != -1) {
            return max_length_matrix[idxFirst][idxSecond][maxCommLen];
        }
        calculationCount.incrementAndGet();
        if (firstString[idxFirst] == secondString[idxSecond]) {
            count1 = maxLengthMemoized(firstString, idxFirst + 1, secondString, idxSecond + 1, maxCommLen + 1, max_length_matrix, calculationCount);
        }

        count2 = maxLengthMemoized(firstString, idxFirst, secondString, idxSecond + 1, 0, max_length_matrix, calculationCount);
        count3 = maxLengthMemoized(firstString, idxFirst + 1, secondString, idxSecond, 0, max_length_matrix, calculationCount);
        max_length_matrix[idxFirst][idxSecond][maxCommLen] = Math.max(count1, Math.max(count2, count3));
        return max_length_matrix[idxFirst][idxSecond][maxCommLen];
    }

    public static int maxLengthTabulized(final String firstString, final String secondString) {
        int maxCommLength = 0;
        if (firstString == null || firstString.length() == 0 || secondString == null || secondString.length() == 0) {
            return 0;
        } else {
            AtomicInteger calculationCount = new AtomicInteger(0);
            int[][] max_length_matrix = Utility.buildAndInit2DMatrix(firstString.length(), secondString.length(), 0);
            max_length_matrix[0][0] = 0;
            for (int ptr1 = 0; ptr1 < firstString.length(); ptr1++) {
                for (int ptr2 = 0; ptr2 < secondString.length(); ptr2++) {
                    calculationCount.incrementAndGet();
                    if (firstString.charAt(ptr1) == secondString.charAt(ptr2)) {
                        max_length_matrix[ptr1 + 1][ptr2 + 1] = 1 + max_length_matrix[ptr1][ptr2];
                        maxCommLength = maxCommLength > max_length_matrix[ptr1 + 1][ptr2 + 1] ? maxCommLength : max_length_matrix[ptr1 + 1][ptr2 + 1];
                    }
                }
            }

            flogger.atInfo().log("Max Calculations in Tabulized Model:" + calculationCount.get());
            return maxCommLength;
        }
    }
}
