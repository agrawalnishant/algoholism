package com.somedomain.ds.containers.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayBackedSimpleQueueTest {

    Queue<Integer> integerQueue;

    @BeforeEach
    void setUp() {
        integerQueue = new ArrayBackedSimpleQueue<>(Integer.class, 9);
    }

    @AfterEach
    void tearDown() {
        integerQueue = null;
    }

    @Test
    void queue() {
        integerQueue.queue(9);
        integerQueue.queue(8);
        integerQueue.queue(7);
        integerQueue.queue(6);
        assertEquals(4,integerQueue.count());
        integerQueue.queue(5);
        integerQueue.queue(4);
        integerQueue.queue(3);
        integerQueue.queue(2);
        integerQueue.queue(1);
        integerQueue.queue(0);
        assertEquals(9,integerQueue.count());
    }

    @Test
    void dequeue() {
        integerQueue.queue(9);
        integerQueue.queue(8);
        integerQueue.queue(7);
        integerQueue.queue(6);
        integerQueue.queue(5);
        integerQueue.queue(4);
        integerQueue.queue(3);
        integerQueue.queue(2);
        integerQueue.queue(1);
        assertEquals(-1, integerQueue.queue(0));
        assertEquals(9, integerQueue.dequeue());
        assertEquals(8, integerQueue.count());
        assertEquals(8, integerQueue.dequeue());
        assertEquals(7, integerQueue.count());
        integerQueue.queue(-1);
        assertEquals(8, integerQueue.count());
    }
}