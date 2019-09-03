package com.somedomain.ds.containers.stack;

import static java.lang.reflect.Array.newInstance;

public class ArrayBackedStack<T extends Object> implements Stack<T> {

    private final T[] backingArray;
    private int top;

    public ArrayBackedStack(Class<T> type, int size) {
        backingArray = (T[]) newInstance(type, size);
    }

    @Override
    public void push(T element) {
        if (!isFull()) {
            backingArray[top] = element;
            top = top + 1;
        }
    }

    @Override
    public T pop() {
        T element = null;
        if (!isEmpty()) {
            element = backingArray[top - 1];
            backingArray[top - 1] = null;
            top = top - 1;
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    @Override
    public boolean isFull() {
        return (top == backingArray.length);
    }

    @Override
    public Integer count() {
        return top;
    }

    @Override
    public T peek() {
        T element = null;
        if (!isEmpty()) {
            element = backingArray[top - 1];
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int counter = 1; counter <= backingArray.length; counter++) {
            stringBuilder.append("," + backingArray[counter - 1]);
        }
        return stringBuilder.toString();
    }

}
