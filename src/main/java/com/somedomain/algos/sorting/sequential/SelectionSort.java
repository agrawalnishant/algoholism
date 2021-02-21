package com.somedomain.algos.sorting.sequential;

import com.somedomain.algos.sorting.PrimitiveSort;

import static com.somedomain.algos.Utility.swapItemsIn;

public class SelectionSort implements PrimitiveSort {

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
            swapItemsIn(sourceArray, outCounter, minPos);
        }
    }
}