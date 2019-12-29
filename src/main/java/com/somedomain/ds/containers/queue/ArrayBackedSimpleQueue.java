package com.somedomain.ds.containers.queue;

import com.google.common.flogger.FluentLogger;
import lombok.Data;

import java.lang.reflect.Array;

@Data
public class ArrayBackedSimpleQueue<T> implements Queue<T> {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private T[] queue;
    private int size;
    private int head;
    private int tail;

    public ArrayBackedSimpleQueue(Class<T> type, int size) {
        this.size = size;
        this.queue = (T[]) Array.newInstance(type, size);
        head = tail = size - 1;
    }

    @Override
    public int queue(final T t) {
        logger.atFine().log("Before adding: " + this);
        int responseCode = NO_HOPE;

        if (tail >= 0) {
            queue[tail--] = t;
            logger.atFine().log("After adding: " + this);
        } else if (head < size - 1) {
            copyFromTailToHead();

            queue[tail--] = t;
            logger.atFine().log("After adding: " + this);
        }

        return responseCode;

    }

    private void copyFromTailToHead() {
        int vacantSpace = size - head - 1;
        int numElements = head - tail;
        logger.atFine().log("Before copy: " + this);
        logger.atFine().log("vacantSpace: " + vacantSpace + ", numElements:" + numElements);

        while (numElements > 0) {
            queue[numElements + vacantSpace - 1] = queue[numElements - 1];
            logger.atFine().log("queue[" + (numElements + vacantSpace - 1) + "] = queue[" + (numElements - 1) + "]");
            numElements--;
        }
        tail = tail + vacantSpace;
        head = head + vacantSpace;
        while (vacantSpace > 0) {
            queue[vacantSpace - 1] = null;
            vacantSpace--;
        }
        logger.atFine().log("After copy adding: " + this);
    }

    @Override
    public T dequeue() {
        T tmpT = queue[head];
        queue[head--] = null;
        logger.atFine().log("After Dequeue: " + this);

        return tmpT;
    }

    @Override
    public int count() {
        return head - tail;
    }

    @Override
    public boolean isEmpty() {
        return head - tail == 0;
    }

    @Override
    public T head() {
        return queue[head];
    }
}
