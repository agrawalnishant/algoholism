package com.somedomain.algos.arraysandstring;

import com.google.common.flogger.FluentLogger;
import com.somedomain.utilities.comparators.IntegerArrayListComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RotateArrayTest {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Test
    void rotateArray() {

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        Collections.addAll(integerArrayList, new Integer[]{5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35});
        ArrayList<Integer> result = RotateArray.rotateArray(integerArrayList, 56);
        logger.atFine().log("Result: " + result);

        ArrayList<Integer> expectedArrayList = new ArrayList<Integer>();
        Collections.addAll(expectedArrayList, new Integer[]{34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35, 5, 14});

        assertTrue(new IntegerArrayListComparator().compare(result, expectedArrayList) == 0);

    }
}