package com.somedomain.algos.sorting;

import com.somedomain.algos.Utility;

public class DutchNationalFlag {
    public static int[] sort(final int[] arr) {
        int left = 0, mid = 0, right = arr.length - 1;
        while (mid >= left && mid <= right) {
            switch (arr[mid]) {
                case 0:
                    Utility.swapItemsIn(arr, mid++, left++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    Utility.swapItemsIn(arr, mid--, right--);
            }
        }

        return arr;
    }

}
