package com.somedomain.problems.arrays.and.string;

import com.google.common.flogger.FluentLogger;

public class ReverseString {

    public String reverseInplace(final String sourceString) {
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