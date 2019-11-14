package com.somedomain.problems.arrays.and.string;

import com.google.common.flogger.FluentLogger;

public class ReplaceChars {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public void replaceAll(final char[] inputString, final char toBeReplaced, final char[] replacement, final int trueLength) {
        logger.atFinest().log("inputString: " + new String(inputString));
        int numToBeReplaced = -1;
        for (int counter = 0; counter < trueLength; counter++) {
            if (inputString[counter] == toBeReplaced) {
                numToBeReplaced++;
            }
        }

        int replacementLength = replacement.length;
        int positionsToBeShifted = numToBeReplaced * replacementLength;
        int indexOfLastChar = trueLength;
        int replacedTimes = 0;
        for (int index = indexOfLastChar - 1; positionsToBeShifted >= 0 && index > 0; index--) {
            if (inputString[index] != toBeReplaced) {
                inputString[index + positionsToBeShifted + replacedTimes] = inputString[index];
            } else {

                for (int counter = 0; counter < replacementLength; counter++) {
                    inputString[index + positionsToBeShifted - counter + replacedTimes] = replacement[replacementLength - counter - 1];
                }
                positionsToBeShifted -= replacementLength;
                ++replacedTimes;
            }
        }

    }
}
