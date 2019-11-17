package com.somedomain.problems.matrix;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;

public class MatrixSpiralTraversal {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static int[] traverseSpirally(final int[][] matrix2D) {

        int rowCount = matrix2D.length;
        int colCount = matrix2D[0].length;
        int[] result = new int[rowCount * colCount];
        int resultIndex = 0;
        int rowIndex = 0;
        int colIndex = 0;
        int spiralIter = 0;
        while (rowIndex + colIndex < rowCount + colCount - 1) {
            for (int i = colIndex; i < colCount - colIndex - 1; i++) {
                result[resultIndex++] = matrix2D[rowIndex][i];
                logger.atFinest().log("#1: rowIndex: " + rowIndex + ", colIndex: " + colIndex + ", i:" + i + ", value: " + matrix2D[rowIndex][i]);
            }
            for (int i = rowIndex; i < rowCount - rowIndex - 1; i++) {
                result[resultIndex++] = matrix2D[i][colCount - colIndex - 1];
                logger.atFinest().log("#2: rowIndex: " + rowIndex + ", colIndex: " + colIndex + ", i:" + i + ", value: " + matrix2D[i][colCount - colIndex - 1]);

            }
            for (int i = colCount - colIndex - 1; i > colIndex; i--) {
                result[resultIndex++] = matrix2D[rowCount - rowIndex - 1][i];

            }
            for (int i = rowCount - rowIndex - 1; i > rowIndex; i--) {
                result[resultIndex++] = matrix2D[i][colIndex];

            }
            rowIndex++;
            colIndex++;
            logger.atFinest().log("current array: " + Arrays.toString(result));
        }
        if (rowCount * colCount % 2 == 1) {
            result[resultIndex++] = matrix2D[rowCount / 2][colCount / 2];
            logger.atFinest().log("final array: " + Arrays.toString(result));
        }

        return result;
    }
}
