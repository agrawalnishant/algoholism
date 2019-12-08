package com.somedomain.ds.dictionaries.heap;

import com.google.common.flogger.FluentLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FastConstructingBinaryMinHeapTest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    Heap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new FasterConstructingBinaryMinHeap<>(Integer.class, 10,
                (Integer one, Integer two) -> Integer.compare(one, two));

    }

    @Test
    void insert() {
        Integer[] arrayOfIntegers = new Integer[]{8, 4, 5, 6, 7, 1, 2, 3, 9};
        heap.insert(arrayOfIntegers);
        heap.showAll();
        List<Integer> heapedList = heap.getHeap();
        for (Integer value : heapedList) {
            assertTrue(heapedList.get(value - 1).equals(value));
        }

    }

}