package com.somedomain.algos.greedy;

public class PoliceThieves {

    public static int policeThief(char[] arr, int k) {
        int[] tS = new int[k], pS = new int[k];
        int tIdx = 0, pIdx = 0, caught = 0;

        int count = 0;
        for (char c : arr) {
            switch (c) {
                case 'P':
                    if (tIdx > 0) {
                        caught++;
                        tIdx--;
                    } else if (pIdx < k) {
                        pIdx++;
                    }
                    break;
                case 'T':
                    if (pIdx > 0) {
                        caught++;
                        pIdx--;
                    } else if (tIdx < k) {
                        tIdx++;
                    }
            }
        }
        return caught;
    }
}
