package com.somedomain.algos;

import com.google.common.flogger.FluentLogger;

public class Partitioning {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private static int[] intArray;

    public static int partiionArray(int[] inputArr) {
        intArray = inputArr;
        int pivot = Utility.selectPivot(intArray);
        return partitionIt(0, inputArr.length - 1, pivot);
    }

    private static int partitionIt(int left, int right, int pivot) {

        int leftPos = left - 1;
        int rightPos = right + 1;

        while (true) {
            while (leftPos < right && intArray[++leftPos] < pivot) {
            }

            while (rightPos > left && intArray[--rightPos] > pivot) {
            }

            if (leftPos >= rightPos) {
                break;
            } else {
                Utility.swapItemsIn(intArray, leftPos, rightPos);
            }

        }

        return leftPos;

    }

    public static void main(String[] args) {

        //int[] input= new int[] {149,192,47,152,159,195,61,66,17,167,118,64,27,80,30,105};
        int[] input = new int[]{149, 192, 47, 152, 159, 195, 678, 112, 10, 167, 118, 64, 27, 80, 30, 175};
        Utility.print(input, "Input: ");
        logger.atFine().log("partition at: " + partiionArray(input));
        Utility.print(input, "output: ");

    }
}
