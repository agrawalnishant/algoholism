package com.somedomain.algos.sorting.archive;

import static com.somedomain.algos.Utility.swap;

public class SelectionSort implements SortingAlgo {

    @Override
    public void sort(int[] sourceArray) {
        int arrayLen = sourceArray.length;
        int maxArrayIndex = arrayLen - 1;
        for (int outCounter = 0; outCounter < maxArrayIndex; outCounter++) {

            int minPos = outCounter;

            // Find the Minimum ( or Maximum) in remaining positions, and bring
            // it to front by swapping.
            for (int inCounter = outCounter + 1; inCounter < arrayLen; inCounter++) {
                if (sourceArray[minPos] > sourceArray[inCounter]) {
                    minPos = inCounter;
                }

            }
            // logger.atFine().log("Swapping sourceArray[" + outCounter + "] = "
            // + sourceArray[outCounter] + " and sourceArray[" + minPos + "] = "
            // + sourceArray[minPos]);

            swap(sourceArray, outCounter, minPos);
            // print(sourceArray, null);
        }
    }
}