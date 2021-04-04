package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestPalindromicStringLength {

    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();
    public static int lengthLongestPalindromeNaive(final String aString) {
        AtomicInteger calculationCount = new AtomicInteger(0);
        int maxPalinLength = aString.length() <= 1 ? aString.length() : maxLengthPalindrome(aString, 0, aString.length() - 1, 0, calculationCount);
        flogger.atInfo().log("Max Calculations in Naive Model for \"" + aString + "\" are :" + calculationCount.get());

        return maxPalinLength;
    }

    private static int maxLengthPalindrome(final String aString, final int start, final int end, int currentMax, AtomicInteger calculationCount) {
        if (start >= aString.length() || end <= 0 || start > end) { //|| idx > aString.length() - currentMax){
            return currentMax;
        } else if (start == end) {
            return currentMax + 1;
        }

        int secIdx = aString.substring(start + 1, end + 1).lastIndexOf(aString.charAt(start));
        int count1 = 0, count2 = 0;
        if (secIdx != -1) {
            calculationCount.incrementAndGet();
            count1 = maxLengthPalindrome(aString, start + 1, secIdx + start, currentMax + 2, calculationCount);
        }
        calculationCount.incrementAndGet();
        count2 = maxLengthPalindrome(aString, start + 1, end, currentMax, calculationCount);
        return Math.max(count1, count2);
    }
}
