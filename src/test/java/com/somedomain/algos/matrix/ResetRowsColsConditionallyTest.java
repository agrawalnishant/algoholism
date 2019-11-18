package com.somedomain.algos.matrix;

import com.somedomain.utilities.comparators.IntegerMatrix2DComparator;
import com.somedomain.utilities.printers.PrintUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResetRowsColsConditionallyTest {

    @Test
    void resetConditionally() {
        int[][] sourceMatrix = {{1, 0, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 0, 16}};
        int[][] expectedMatrix = {{0, 0, 0, 0}, {5, 0, 0, 8}, {9, 0, 0, 12}, {0, 0, 0, 0}};
        ResetRowsColsConditionally.resetConditionally(sourceMatrix, 0, 0);
        assertTrue(new IntegerMatrix2DComparator().compare(expectedMatrix, sourceMatrix) == 0, () -> "Reset Matrix should be " + PrintUtility.print2D(expectedMatrix));

    }
}