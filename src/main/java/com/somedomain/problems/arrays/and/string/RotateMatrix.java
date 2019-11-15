package com.somedomain.problems.arrays.and.string;

import com.google.common.flogger.FluentLogger;

public class RotateMatrix {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public void rotateMatrixClockwise(final int[][] sourceMatrix) {
        int edgeLen = sourceMatrix.length;
        int tmpValueSrc = sourceMatrix[0][0];
        for (int rowCount = 0; rowCount <= (edgeLen - 1) / 2; rowCount++) {
            for (int colCounter = rowCount; colCounter < edgeLen - rowCount - 1; colCounter++) {
                logger.atFinest().log("(rowCount, colCounter): ( " + rowCount + ", " + colCounter + ")");
                int[] targetXY = {rowCount, colCounter};
                tmpValueSrc = sourceMatrix[rowCount][colCounter];
                for (int rotation = 0; rotation < 4; rotation++) {
                    targetXY = findTargetRowColCoords(targetXY, edgeLen);
                    int tmpValueTar = sourceMatrix[targetXY[0]][targetXY[1]];
                    sourceMatrix[targetXY[0]][targetXY[1]] = tmpValueSrc;
                    tmpValueSrc = tmpValueTar;
                }

            }
        }

    }

    protected int[] findTargetRowColCoords(int[] coordsXY, final int rowMax) {
        int[] resultingRowColCoords = new int[2];
        resultingRowColCoords[0] = coordsXY[1];
        resultingRowColCoords[1] = rowMax - coordsXY[0] - 1;

        System.out.println("Target for (" + coordsXY[0] + "," + coordsXY[1] + ") is : (" + resultingRowColCoords[0] + "," + resultingRowColCoords[1] + ")");
        return resultingRowColCoords;

    }
}
