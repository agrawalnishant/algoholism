package com.somedomain.problems.string;

import com.google.common.flogger.FluentLogger;

public class Anagram {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public boolean areAnagrams(final String sourceString, final String testString) {
        logger.atFinest().log("Source String: " + sourceString + ", test String: " + testString);
        if (sourceString == testString) {
            return true;
        }
        if (null != testString && null != sourceString && sourceString.equals(testString)) {
            return true;
        }
        int charsetSize = 256;

        int[] sourceDistri = new int[charsetSize];
        for (int c : sourceString.toCharArray()) {
            sourceDistri[c]++;
        }
        for (char c : testString.toCharArray()) {
            if (sourceDistri[c]-- <= 0) {
                logger.atFinest().log("Anomaly[Less char in source ] \t: Char: " + ((char) (c )));

                return false;
            }
        }
        for (int sourceIndex = 0; sourceIndex < sourceDistri.length; sourceIndex++) {
            if (sourceDistri[sourceIndex] != 0) {
                logger.atFinest().log("Anomaly[Excess in source ]: Char: " + ((char) (sourceIndex)));
                return false;
            }
        }
        return true;
    }
}