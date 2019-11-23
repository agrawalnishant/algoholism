package com.somedomain.algos.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TraverseGridTest {

    @ParameterizedTest(name = "{2} paths from {0} to {1}")
    @CsvSource({

            "1:1 , 3:3, 6",
            "0:0 , 3:3, 20"
    })
    void traverse(final String fromXY, final String toXY, final String expectedPaths) {
        String[] arr = fromXY.split(":");
        TraverseGrid traverseGrid = new TraverseGrid();
        Point source = new Point(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));

        arr = toXY.split(":");
        Point dest = new Point(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
        assertEquals(Integer.valueOf(expectedPaths), traverseGrid.traverse(source, dest), () -> "Expected paths are " + expectedPaths);
    }
}