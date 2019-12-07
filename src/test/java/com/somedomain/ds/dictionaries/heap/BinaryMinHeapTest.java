package com.somedomain.ds.dictionaries.heap;

import com.google.common.flogger.FluentLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryMinHeapTest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    Heap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new BinaryMinHeap<>(Integer.class, 10,
                (Integer one, Integer two) -> Integer.compare(one, two));

    }

    @Test
    void insert() {
        heap.insert(new Integer(3));
        heap.insert(4);
        heap.insert(2);
        heap.insert(1);
        heap.showAll();
        List<Integer> heapedList = heap.getHeap();
        assertTrue(heapedList.get(0) == 1);

    }

    @Test
    void getListOfElements() {
    }
}