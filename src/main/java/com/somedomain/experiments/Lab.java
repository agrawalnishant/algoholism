package com.somedomain.experiments;

public class Lab {

    public static void main(String[] args) {
        int[] arr = new int[2];
        arr[0] = 5;
        arr[1] = 8;

        arr[0] = (arr[0] ^ arr[1]);
        arr[1] = (arr[0] ^ arr[1]);
        arr[0] = (arr[0] ^ arr[1]);

    }

}
