package com.somedomain.problems.matrix;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;

public class ResetRowsColsConditionally {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void resetConditionally(int[][] matrix2D, int current, int target) {
        int rowCount = matrix2D.length;
        int colCount = matrix2D[0].length;
        boolean[] occurRows = new boolean[rowCount];
        int rowOccuIndex = 0;
        boolean[] occurCols = new boolean[colCount];
        for (int row = 0; row < rowCount; row++) {
            boolean hasOccu = false;
            for (int col = 0; col < colCount; col++) {
                if (occurCols[col] == false && matrix2D[row][col] == current) {
                    occurCols[col] = true;
                    hasOccu = true;
                }
            }

            if (hasOccu == true) {
                occurRows[row] = true;
                hasOccu = false;
            }
        }
        logger.atFinest().log("Occurances: rows: " + Arrays.toString(occurRows) + ", cols: " + Arrays.toString(occurCols));
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (occurRows[row] == true || occurCols[col] == true)
                    matrix2D[row][col] = target;
            }
        }

    }
}
