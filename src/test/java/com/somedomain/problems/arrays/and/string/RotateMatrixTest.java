package com.somedomain.problems.arrays.and.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void rotateMatrixClockwise() {
        int[][] sourceMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        print2D(sourceMatrix);
        rotateMatrix.rotateMatrixClockwise(sourceMatrix);
        print2D(sourceMatrix);
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            System.out.println("");
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");

        }
        System.out.println("");
    }
}