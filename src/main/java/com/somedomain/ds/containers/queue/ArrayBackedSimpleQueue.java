package com.somedomain.ds.containers.queue;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class ArrayBackedSimpleQueue<T> implements Queue<T> {

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
        System.out.println("Before adding: " + this);
        int responseCode = NO_HOPE;

        if (tail >= 0) {
            queue[tail--] = t;
            System.out.println("After adding: " + this);
        } else if (head < size - 1) {
            copyFromTailToHead();

            queue[tail--] = t;
            System.out.println("After adding: " + this);
        }


        return responseCode;

    }

    private void copyFromTailToHead() {
        int vacantSpace = size - head - 1;
        int numElements = head - tail;
        System.out.println("Before copy: " + this);
        System.out.println("vacantSpace: " + vacantSpace + ", numElements:" + numElements);

        while (numElements > 0) {
            queue[numElements + vacantSpace - 1] = queue[numElements - 1];
            System.out.println("queue[" + (numElements + vacantSpace - 1) + "] = queue[" + (numElements -1) + "]");
            numElements--;
        }
        tail = tail + vacantSpace ;
        head = head + vacantSpace;
        while (vacantSpace > 0) {
            queue[vacantSpace-1] = null;
            vacantSpace--;
        }
        System.out.println("After copy adding: " + this);
    }

    @Override
    public T dequeue() {
        T tmpT = queue[head];
        queue[head--] = null;
        System.out.println("After Dequeue: " + this);

        return tmpT;
    }

    @Override
    public int count() {
        return head - tail;
    }
}
