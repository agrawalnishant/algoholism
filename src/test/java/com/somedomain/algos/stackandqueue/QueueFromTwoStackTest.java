package com.somedomain.algos.stackandqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueFromTwoStackTest {

    private QueueFromTwoStack<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueFromTwoStack(Integer.class);

    }

    @Test
    void testQueueAndDequeuePartial() {
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.queue(4);
        assertTrue(queue.count() == 4);
        assertTrue(queue.dequeue().equals(1));
        assertTrue(queue.dequeue().equals(2));
        queue.queue(5);
        assertTrue(queue.dequeue().equals(3));
        assertTrue(queue.dequeue().equals(4));
        assertTrue(queue.dequeue().equals(5));
        assertTrue(queue.count() == 0);
    }

    @Test
    void testQueueAndDequeueFull() {
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.queue(4);
        assertTrue(queue.count() == 4);
        assertTrue(queue.dequeue().equals(1));
        assertTrue(queue.dequeue().equals(2));
        queue.queue(5);
        queue.queue(6);
        queue.queue(7);
        queue.queue(8);
        queue.queue(9);
        queue.queue(10);
        assertTrue(queue.dequeue().equals(3));
        assertTrue(queue.dequeue().equals(4));
        assertTrue(queue.dequeue().equals(5));
        assertTrue(queue.dequeue().equals(6));
        assertTrue(queue.dequeue().equals(7));
        assertTrue(queue.dequeue().equals(8));
        assertTrue(queue.dequeue().equals(9));
        assertTrue(queue.dequeue().equals(10));
        assertTrue(queue.count() == 0);
    }

}