package com.somedomain.algos.sorting;

public class Practice {


    public static void main(String[] args) {
        int[][] matrix = {{10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 80}};
        //System.out.println(findKey(matrix, matrix.length, matrix[0].length, 18));
        int[] arr = new int[]{1, 2, 55, 100, -100, -50, -10};
        System.out.println(searchRotatedArray(arr, 0, 6, -100));
        arr = new int[]{5, 6, 7, 1, 2, 3, 4};
        System.out.println(searchRotatedArray(arr, 0, 6, 0));
        arr = new int[]{2, 2, 2, 2, 4, 5, 3};
        System.out.println(searchRotatedArray(arr, 0, 6, 2));
        arr = new int[]{5, 5, 5, 5, 5, 5, 5};
        System.out.println(searchRotatedArray(arr, 0, 6, 0));
        arr = new int[]{5, 5, 5, 5, 5, 5, 5};
        System.out.println(searchRotatedArray(arr, 0, 6, 5));

    }


    static int searchRotatedArray(int arr[], int left, int right, int n) {
        int mid = (left + right) / 2;
        if (left > right || left < 0 || right > arr.length - 1) {
            return -1;
        }
        System.out.println("mid:" + mid);
        if (arr[mid] == n) {
            return mid;
        }
        if (mid > 0 && mid < arr.length - 1 && arr[left] <= arr[mid - 1]) {
            if (n >= arr[left] & n <= arr[mid - 1]) {
                return searchRotatedArray(arr, left, mid - 1, n);
            } else {
                return searchRotatedArray(arr, mid + 1, right, n);
            }
        } else if (mid > 0 && mid < arr.length - 1 && arr[mid + 1] < arr[right]) {
            if (n >= arr[mid + 1] & n <= arr[right]) {
                return searchRotatedArray(arr, mid + 1, right, n);
            } else {
                return searchRotatedArray(arr, left, mid - 1, n);
            }
        }
        return -1;
    }
}
