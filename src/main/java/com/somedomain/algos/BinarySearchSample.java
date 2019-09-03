package com.somedomain.algos;

import com.google.common.flogger.FluentLogger;

import static com.somedomain.algos.Utility.createArray;

public class BinarySearchSample {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        BinarySearchSample sample = new BinarySearchSample();

        int arrayLength = 100;
        int[] integerArray = createArray(arrayLength, true);
        int randomIndex = new Double(Math.random() * (1.0 * arrayLength)).intValue();
        int targetNum = integerArray[randomIndex];

        logger.atFine().log("target pos: " + randomIndex + ", num: " + targetNum);

        logger.atFine().log("searched pos: " + sample.binSearch(integerArray, targetNum, 0, arrayLength - 1));

    }

    public int binSearch(int[] inputArray, int num, int startPos, int endPos) {

        logger.atFine().log("Num: " + num + ", start: " + startPos + ", end: " + endPos);
        int midpos = (startPos + endPos) / 2;

        int start = inputArray[startPos];
        int end = inputArray[endPos];
        int mid = inputArray[midpos];

        if (num < inputArray[startPos] || num > inputArray[endPos] || startPos == endPos) {
            return -1;
        } else if (num == start) {
            return startPos;
        } else if (num == end) {
            return endPos;
        } else if (num == mid) {
            return midpos;
        }

        logger.atFine().log("Mid: " + midpos + ", Num at mid: " + mid);

        if (num < mid) {
            return binSearch(inputArray, num, startPos, midpos);

        } else {
            return binSearch(inputArray, num, midpos, endPos);

        }
    }

}
