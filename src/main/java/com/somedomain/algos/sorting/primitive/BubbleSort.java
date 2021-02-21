package com.somedomain.algos.sorting.primitive;

import com.somedomain.algos.sorting.PrimitiveSort;

import static com.somedomain.algos.Utility.swapItemsIn;


public class BubbleSort implements PrimitiveSort {

    @Override
    public void sort(int[] sourceArray) {
        int arrayLen = sourceArray.length;
        // Keep swapping successive elements to bubble-up maximum / minimum, to
        // top.
        for (int outCounter = 0; outCounter < arrayLen - 1; outCounter++) {
            for (int inCounter = 0; inCounter < arrayLen - outCounter - 1; inCounter++) {
                if (sourceArray[inCounter] > sourceArray[inCounter + 1]) {
                    swapItemsIn(sourceArray, inCounter, inCounter + 1);
                }
            }
        }
    }
}
