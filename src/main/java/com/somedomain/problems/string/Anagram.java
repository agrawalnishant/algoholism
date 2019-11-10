package com.somedomain.problems.string;

import com.google.common.flogger.FluentLogger;

public class Anagram {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private static final String TEST_STRING_UNIQ = "ABCDEF";
    private static final String TEST_STRING_PERMUTATION_OF_UNIQ = "ABEDC";

    public static void main(String[] args) {
        logger.atFinest().log("Is " + "ABCBDEF" + " permutation of " + "ABCDEFB" + " : "
                + arePermutations(TEST_STRING_UNIQ, TEST_STRING_PERMUTATION_OF_UNIQ));
    }

    private static boolean arePermutations(final String sourceString, final String targetString) {
        if (sourceString == targetString) {
            return true;
        }
        if (null != targetString && null != sourceString && sourceString.equals(targetString)) {
            return true;
        }
        int charsetSize = 256;

        int lengthOfSource = sourceString.length();
        int[] sourceDistri = new int[charsetSize];
        for (int c : sourceString.toCharArray()) {
            sourceDistri[c]++;
        }
        for (char c : targetString.toCharArray()) {
            if (sourceDistri[c]-- <= 0) {
                return false;
            }
        }
        return true;
    }
}