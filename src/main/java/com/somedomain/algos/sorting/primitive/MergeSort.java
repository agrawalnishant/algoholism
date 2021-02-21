package com.somedomain.algos.sorting.primitive;
import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.sorting.PrimitiveSort;

public class MergeSort implements PrimitiveSort {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public void sort(final int[] sourceArray) {

        mergeSort(sourceArray, 0, sourceArray.length - 1);
    }

    private void mergeSort(final int[] arr, final int left, final int right) {
        if (left < 0 || right < 0 || left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(final int[] arr, final int left, final int mid, final int right) {
        //logger.atFine().log("left, mid, right:" + left +"," + mid + "," + right);
        int leftLen = mid - left + 1;
        int rightLen = right - mid ;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightLen; j++) {
            rightArr[j] = arr[mid + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i++];
            } else {
                arr[k] = rightArr[j++];
            }
            k++;
        }
        while (i < leftLen) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightLen) {
            arr[k++] = rightArr[j++];
        }

    }
}