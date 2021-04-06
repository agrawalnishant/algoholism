package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.Utility;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestPalindromicStringLength {

    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();

    public static int lengthLongestPalindromeNaive(final String aString) {
        AtomicInteger calculationCount = new AtomicInteger(0);
        int maxPalinLength = aString.length() <= 1 ? aString.length() : maxLengthPalindromeNaive(aString, 0, aString.length() - 1, calculationCount);
        flogger.atInfo().log("Max Calculations in Naive Model for \"" + aString + "\" are :" + calculationCount.get());

        return maxPalinLength;
    }

    private static int maxLengthPalindromeNaive(final String aString, final int start, final int end, AtomicInteger calculationCount) {
        if (start >= aString.length() || end <= 0 || start > end) {
            return 0;
        } else if (start == end) {
            return 01;
        }
        calculationCount.incrementAndGet();
        if (aString.charAt(start) == aString.charAt(end)) {
            return 2 + maxLengthPalindromeNaive(aString, start + 1, end - 1, calculationCount);
        }
        int count1 = maxLengthPalindromeNaive(aString, start + 1, end, calculationCount);
        int count2 = maxLengthPalindromeNaive(aString, start, end - 1, calculationCount);
        return Math.max(count1, count2);
    }

    public static int lengthLongestPalindromeMemoized(final String aString) {
        AtomicInteger calculationCount = new AtomicInteger(0);
        int[][] lookupTable = Utility.buildAndInit2DMatrix(aString.length() + 1, aString.length() + 1, -1);
        int maxPalinLength = aString.length() <= 1 ? aString.length() : maxLengthPalindromeMemoized(aString, 0, aString.length() - 1, lookupTable, calculationCount);
        flogger.atInfo().log("Max Calculations in Memoized Model for \"" + aString + "\" are :" + calculationCount.get());

        return maxPalinLength;
    }

    private static int maxLengthPalindromeMemoized(final String aString, final int start, final int end, int[][] lookupTable, AtomicInteger calculationCount) {
        if (start > aString.length() || end < 0 || start > end) {
            return 0;
        } else if (start == end) {
            return 1;
        }
        if (lookupTable[start][end] != -1) {
            return lookupTable[start][end];
        }
        calculationCount.incrementAndGet();
        if (aString.charAt(start) == aString.charAt(end)) {
            lookupTable[start][end] = 2 + maxLengthPalindromeMemoized(aString, start + 1, end - 1, lookupTable, calculationCount);
        } else {
            int count1 = maxLengthPalindromeMemoized(aString, start + 1, end, lookupTable, calculationCount);
            int count2 = maxLengthPalindromeMemoized(aString, start, end - 1, lookupTable, calculationCount);
            lookupTable[start][end] = Math.max(count1, count2);
        }
        return lookupTable[start][end];
    }

    public static int lengthLongestPalindromeTabulized(final String aString) {

        if (aString.length() <= 0) {
            return 0;
        } else if (aString.length() == 1) {
            return 1;
        }
        AtomicInteger calculationCount = new AtomicInteger(0);
        int[][] lookupTable = Utility.buildAndInit2DUnityDiagonalMatrix(aString.length(), aString.length(), 0);
        int maxPalinLength = 0;
        int strLen = aString.length();
        for (int counter = strLen - 1; counter >= 0; counter--) {
            for (int idx = counter + 1; idx < strLen; idx++, calculationCount.incrementAndGet()) {
                if (aString.charAt(counter) == aString.charAt(idx)) {
                    lookupTable[counter][idx] = 2 + lookupTable[counter + 1][idx - 1];
                } else {
                    lookupTable[counter][idx] = Math.max(lookupTable[counter][idx - 1], lookupTable[counter + 1][idx]);
                }
            }
        }
        maxPalinLength = lookupTable[0][strLen - 1];
        flogger.atInfo().log("Max Calculations in Tabulized Model for \"" + aString + "\" are :" + calculationCount.get());
        return maxPalinLength;
    }
}