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
        heap.insert(6);
        heap.insert(1);
        heap.insert(8);
        heap.insert(9);
        heap.showAll();
        List<Integer> heapedList = heap.getHeap();
        assertTrue(heapedList.get(0) == 1);

    }

    @Test
    void getNextAndHeapify() {
        heap.insert(new Integer(3));
        heap.insert(4);
        heap.insert(2);
        heap.insert(6);
        heap.insert(1);
        heap.insert(8);

        heap.showAll();
        Integer next = heap.getNextAndHeapify();
        List<Integer> heapedList = heap.getHeap();
        heap.showAll();
        assertTrue(heapedList.get(0) == 2);
        next = heap.getNextAndHeapify();
        heapedList = heap.getHeap();
        heap.showAll();
        logger.atFinest().log("Num Search Ops: " + heap.getNumOpsSearch());
        heap.insert(9);
        next = heap.getNextAndHeapify();
        heap.showAll();
        assertTrue(heapedList.get(0) == 4);
        logger.atFinest().log("Num Search Ops: " + heap.getNumOpsSearch());

    }
}