package com.somedomain.ds.containers.stack;

import static java.lang.reflect.Array.newInstance;

public class ArrayBackedStack<T extends Object> implements Stack<T> {

    private final T[] backingArray;
    private int top;
    private String name;

    public ArrayBackedStack(Class<T> type, int size) {
        this(type, size, "" + Double.valueOf(Math.random()).intValue());
    }

    public ArrayBackedStack(Class<T> type, int size, final String name) {
        backingArray = (T[]) newInstance(type, size);
        this.name = name;
    }

    @Override
    public void push(T t) {
        if (!isFull()) {
            backingArray[top] = t;
            top = top + 1;
        }

    }

    @Override
    public T pop() {
        T t = null;
        if (!isEmpty()) {
            t = backingArray[top - 1];
            backingArray[top - 1] = null;
            top = top - 1;
        }

        return t;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int counter = 1; counter <= backingArray.length; counter++) {
            stringBuilder.append("," + backingArray[counter - 1]);
        }

        return stringBuilder.toString();
    }

}
