package com.somedomain.algos.sorting.divideconquer;

import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.sorting.Sorter;
import com.somedomain.utilities.comparators.IntegerArrayListComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSorterTest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
    private Comparator<Integer> integerComparator = (Integer one, Integer two) -> {
        return one - two;
    };
    Sorter<Integer> sorter = new MergeSorter<Integer>(Integer.class, integerComparator);

    ArrayList<Integer> expectedIntegerArrayList = new ArrayList<Integer>();

    @BeforeEach
    void setUp() {
        Collections.addAll(listOfIntegers, new Integer[]{10, 5, 3, 9, 1, 15});
        Collections.addAll(expectedIntegerArrayList, new Integer[]{1, 3, 5, 9, 10, 15});
    }

    @Test
    void sort() {
        sorter.sort(listOfIntegers);
        IntegerArrayListComparator integerArrayListComparator = new IntegerArrayListComparator();
        assertEquals(integerArrayListComparator.compare(listOfIntegers, expectedIntegerArrayList), 0);
    }
}