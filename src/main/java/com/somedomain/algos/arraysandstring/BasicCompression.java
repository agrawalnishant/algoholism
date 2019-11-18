package com.somedomain.algos.arraysandstring;

import com.google.common.flogger.FluentLogger;

public class BasicCompression {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public String compress(final String sourceString) {
        logger.atFinest().log("Source String: " + sourceString);
        final StringBuilder compressedString = new StringBuilder();
        final char[] sourceArray = sourceString.toCharArray();
        int prevCharCounter = 0;
        char prevChar = 0;
        int sourceLength = sourceArray.length;
        int compressedLength = 0;
        int maxCompression = 1;
        for (int counter = 0; counter < sourceLength; counter++) {
            char nextCh = sourceArray[counter];
            logger.atFinest().log("Got Char: " + nextCh);
            if (counter == 0) {
                prevChar = nextCh;
                prevCharCounter++;
            } else if (counter == sourceLength - 1) {
                if (nextCh == prevChar) {
                    prevCharCounter++;
                    compressedString.append(prevChar).append(prevCharCounter);
                    compressedLength += 2;
                } else {
                    compressedString.append(prevChar).append(prevCharCounter).append(nextCh).append(1);
                    compressedLength += 4;
                }
            } else {
                if (nextCh == prevChar) {
                    prevCharCounter++;
                } else {
                    compressedString.append(prevChar).append(prevCharCounter);
                    compressedLength += 2;
                    prevCharCounter = 1;
                    prevChar = nextCh;

                }
            }
            if (maxCompression < prevCharCounter) {
                maxCompression = prevCharCounter;
            }
            logger.atFinest().log("Compressed form: " + compressedString.toString());
        }
        if (maxCompression <= 1) {
            return sourceString;
        } else {
            return compressedString.toString();
        }
    }
}
