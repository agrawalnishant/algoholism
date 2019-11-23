package com.somedomain.algos.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.util.StringUtils;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TraverseGridTest {

    @ParameterizedTest(name = "{3} paths from {0} to {1}")
    @CsvSource({

            "0:0 , 0:0, ,1",
            "1:1 , 3:3, ,  6",
            "1:1 , 3:3, 2:2,  2",
            "1:1 , 3:3, 1:2,  3",
            "0:0 , 3:3, , 20"
    })
    void traverse(final String fromXY, final String toXY, final String avoidXY, final String expectedPaths) {
        String[] arr = fromXY.split(":");
        TraverseGrid traverseGrid = new TraverseGrid();
        Point source = new Point(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));

        arr = toXY.split(":");
        Point dest = new Point(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));

        ArrayList<Point> exclusions = new ArrayList<Point>();
        if (StringUtils.isNotBlank(avoidXY)) {
            arr = avoidXY.split(":");
            Point exclude = new Point(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
            exclusions.add(exclude);
        }
        assertEquals(Integer.valueOf(expectedPaths), traverseGrid.traverse(source, dest, exclusions), () -> "Expected paths are " + expectedPaths);
    }
}