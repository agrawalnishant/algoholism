package com.somedomain.algos.stackandqueue;

import com.somedomain.ds.containers.queue.Queue;
import com.somedomain.ds.containers.stack.ArrayBackedStack;
import com.somedomain.ds.containers.stack.Stack;

public class QueueFromTwoStack<T> implements Queue<T> {

    private static final Integer DEFAULT_SIZE = 10;

    private int size;
    private final Stack<T> stackHead;
    private final Stack<T> stackTail;

    private Stack<T> createStack(Class<T> type) {
        return new ArrayBackedStack<T>(type, DEFAULT_SIZE);
    }

    public QueueFromTwoStack(Class<T> type) {
        this.stackHead = createStack(type);
        this.stackTail = createStack(type);
    }

    @Override
    public int queue(T element) {
        if (!stackHead.isFull()) {
            stackTail.push(element);
            return ++size;
        } else {
            if (stackHead.isEmpty()) {
                transferToHead();
                stackTail.push(element);
                return ++size;
            } else {
                return NO_HOPE;
            }
        }

    }

    private void transferToHead() {
        while (!stackTail.isEmpty()) {
            stackHead.push(stackTail.pop());

        }
    }

    @Override
    public T dequeue() {
        if (!stackHead.isEmpty()) {
            size--;
            return stackHead.pop();
        }
        if (stackHead.isEmpty() && !stackTail.isEmpty()) {
            transferToHead();
            size--;
            return stackHead.pop();
        }

        return null;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return stackHead.isEmpty() && stackTail.isEmpty();
    }

    @Override
    public T head() {
        if (!stackHead.isEmpty()) {
            return stackHead.peek();
        } else if (!stackTail.isEmpty()) {
            return stackTail.peek();
        } else {
            return null;
        }
    }
}
