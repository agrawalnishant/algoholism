package com.somedomain.problems.matrix;

import com.somedomain.comparators.IntegerArrayComparator;
import com.somedomain.printers.PrintUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class MatrixSpiralTraversalTest {

    @Test
    void traverseSpirally4X4() {
        int[][] sourceMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] expectedMatrix = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};
        int[] result = MatrixSpiralTraversal.traverseSpirally(sourceMatrix);
        assertTrue(new IntegerArrayComparator().compare(expectedMatrix, result) == 0, () -> "Spiral Traversal should be " + Arrays.toString(expectedMatrix));
    }

    @Test
    void traverseSpirally5X5() {
        int[][] sourceMatrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[] expectedMatrix = {1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13};
        int[] result = MatrixSpiralTraversal.traverseSpirally(sourceMatrix);
        assertTrue(new IntegerArrayComparator().compare(expectedMatrix, result) == 0, () -> "Spiral Traversal should be " + Arrays.toString(expectedMatrix));
    }

    @Test
    void traverseSpirally6X5() {
        int[][] sourceMatrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}, {26, 27, 28, 29, 30}};
        int[] expectedMatrix = {1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 29, 28, 27, 26, 21, 16, 11, 6, 7, 8, 9, 14, 19, 24, 23, 22, 17, 12, 13, 18};
        int[] result = MatrixSpiralTraversal.traverseSpirally(sourceMatrix);
        assertTrue(new IntegerArrayComparator().compare(expectedMatrix, result) == 0, () -> "Spiral Traversal should be " + Arrays.toString(expectedMatrix));
    }

    @Test
    void traverseSpirally3X3() {
        int[][] sourceMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expectedMatrix = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        int[] result = MatrixSpiralTraversal.traverseSpirally(sourceMatrix);
        assertTrue(new IntegerArrayComparator().compare(expectedMatrix, result) == 0, () -> "Spiral Traversal should be " + Arrays.toString(expectedMatrix));
    }
}