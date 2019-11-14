package com.somedomain.problems.arrays.and.string;

public class RotateMatrix {

    public void rotateMatrixClockwise(final int[][] sourceMatrix) {
        int edgeLen = sourceMatrix.length;
        int tmpValueSrc = sourceMatrix[0][0];
        for (int rowCount = 0; rowCount <= (edgeLen - 1) / 2; rowCount++) {
            for (int colCounter = rowCount; colCounter < edgeLen - rowCount - 1; colCounter++) {
                System.out.println("(rowCount, colCounter): ( " + rowCount + ", " + colCounter + ")");
                int[] sourceXY = {rowCount, colCounter};
                tmpValueSrc = sourceMatrix[rowCount][colCounter];
                int[] targetXY = findTargetRowColCoords(sourceXY, edgeLen);
                int tmpValueTar = sourceMatrix[targetXY[0]][targetXY[1]];
                sourceMatrix[targetXY[0]][targetXY[1]] = tmpValueSrc;
                tmpValueSrc = tmpValueTar;

                targetXY = findTargetRowColCoords(targetXY, edgeLen);
                tmpValueTar = sourceMatrix[targetXY[0]][targetXY[1]];
                sourceMatrix[targetXY[0]][targetXY[1]] = tmpValueSrc;
                tmpValueSrc = tmpValueTar;

                targetXY = findTargetRowColCoords(targetXY, edgeLen);
                tmpValueTar = sourceMatrix[targetXY[0]][targetXY[1]];
                sourceMatrix[targetXY[0]][targetXY[1]] = tmpValueSrc;
                tmpValueSrc = tmpValueTar;

                targetXY = findTargetRowColCoords(targetXY, edgeLen);
                tmpValueTar = sourceMatrix[targetXY[0]][targetXY[1]];
                sourceMatrix[targetXY[0]][targetXY[1]] = tmpValueSrc;
                tmpValueSrc = tmpValueTar;

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
