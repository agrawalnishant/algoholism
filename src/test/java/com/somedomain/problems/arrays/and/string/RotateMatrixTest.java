package com.somedomain.problems.arrays.and.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void rotateMatrixClockwise() {
        int[][] sourceMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] expectedMatrix = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotateMatrixClockwise(sourceMatrix);
        assertTrue(compareMatrices(expectedMatrix, sourceMatrix), () -> "Rotated Matrix should be " + print2D(expectedMatrix))
        ;

    }

    private static boolean compareMatrices(int[][] matrixOne, int[][] matrixTwo) {

        boolean result = false;
        if (matrixOne.length == matrixTwo.length && matrixOne[0].length == matrixTwo[0].length) {
            result = true;
            for (int row = 0; result == true && row < matrixOne.length; row++) {
                for (int col = 0; result == true && col < matrixOne[0].length; col++) {
                    if (matrixOne[row][col] != matrixTwo[row][col]) {
                        result = false;
                    }
                }
            }
        }
        return result;

    }

    public static String print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            System.out.println("");
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");

        }
        System.out.println("");
        return "";
    }
}