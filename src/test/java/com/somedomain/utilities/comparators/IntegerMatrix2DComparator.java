package com.somedomain.utilities.comparators;

import java.util.Comparator;

public class IntegerMatrix2DComparator implements Comparator<int[][]> {
    @Override
    public int compare(int[][] matrixOne, int[][] matrixTwo) {
        int result = -1;
        if (matrixOne.length == matrixTwo.length && matrixOne[0].length == matrixTwo[0].length) {
            result = 0;
            for (int row = 0; result == 0 && row < matrixOne.length; row++) {
                for (int col = 0; result == 0 && col < matrixOne[0].length; col++) {
                    if (matrixOne[row][col] != matrixTwo[row][col]) {
                        result = -1;
                    }
                }
            }
        }
        return result;
    }
}