package com.somedomain.problems.arrays.and.string;

import com.somedomain.comparators.IntegerMatrix2DComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void rotateMatrixClockwise() {
        int[][] sourceMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] expectedMatrix = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotateMatrixClockwise(sourceMatrix);
        assertTrue(new IntegerMatrix2DComparator().compare(expectedMatrix, sourceMatrix) == 0, () -> "Rotated Matrix should be " + print2D(expectedMatrix))
        ;

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