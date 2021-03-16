package com.somedomain.algos.sorting.generic;

import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.sorting.ObjectSort;
import com.somedomain.utilities.comparators.IntegerArrayListComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeObjectSortTest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private final ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
    private final Comparator<Integer> integerComparator = (Integer one, Integer two) -> {
        return one - two;
    };
    ObjectSort<Integer> objectSort = new MergeObjectSort<Integer>(Integer.class, integerComparator);

    ArrayList<Integer> expectedIntegerArrayList = new ArrayList<Integer>();

    @BeforeEach
    void setUp() {
        Collections.addAll(listOfIntegers, 10, 5, 3, 9, 1, 15);
        Collections.addAll(expectedIntegerArrayList, 1, 3, 5, 9, 10, 15);
    }

    @Test
    void sort() {
        objectSort.sort(listOfIntegers);
        IntegerArrayListComparator integerArrayListComparator = new IntegerArrayListComparator();
        assertEquals(integerArrayListComparator.compare(listOfIntegers, expectedIntegerArrayList), 0);
    }
}