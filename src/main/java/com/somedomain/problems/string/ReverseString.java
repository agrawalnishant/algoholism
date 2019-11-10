package com.somedomain.problems.string;

import com.google.common.flogger.FluentLogger;

public class ReverseString {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private static final String TEST_STRING_REPEAT = "ABCDEFABC";

    public static void main(String[] args) {
        logger.atFinest().log(TEST_STRING_REPEAT + " : reversed : " + reverseInplace(TEST_STRING_REPEAT));
    }

    private static String reverseInplace(final String sourceString) {
        if (sourceString == null || sourceString.length() <= 1)
            return sourceString;
        char[] sourceStringChars = sourceString.toCharArray();
        int length = sourceString.length();
        int forwardCounter = 0;
        int backwardCounter = length - 1;

        while (forwardCounter <= backwardCounter) {
            int diff = sourceStringChars[forwardCounter] - sourceStringChars[backwardCounter];
            sourceStringChars[backwardCounter] = sourceStringChars[forwardCounter];
            sourceStringChars[forwardCounter] = (char) (sourceStringChars[forwardCounter] - diff);
            forwardCounter++;
            backwardCounter--;
        }
        return new String(sourceStringChars);
    }
}