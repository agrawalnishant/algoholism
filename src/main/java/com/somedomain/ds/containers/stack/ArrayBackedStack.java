package com.somedomain.ds.containers.stack;

public class ArrayBackedStack<T extends Object> implements Stack<T> {

    private final T[] backingArray;
    private int top;
    private String name;
    public ArrayBackedStack(Class<T> type, int size) {
        this(type, size, "" + Double.valueOf(Math.random()).intValue());
    }

    public ArrayBackedStack(Class<T> type, int size, final String name) {
        backingArray =  (T[]) java.lang.reflect.Array.newInstance(type,size);
        this.name = name;
    }

    public static void main(String[] args) {
        Stack<Integer> stackOfIntegers = new ArrayBackedStack<Integer>(Integer.class, 5);
        System.out.println("isEmpty: " + (stackOfIntegers.isEmpty()));
        stackOfIntegers.push(1);
        stackOfIntegers.push(2);
        stackOfIntegers.push(3);
        stackOfIntegers.push(4);
        stackOfIntegers.push(5);
        System.out.println(stackOfIntegers);
        System.out.println(stackOfIntegers.pop());

        System.out.println("isFull: " + stackOfIntegers.isFull());
        System.out.println("isEmpty: " + (stackOfIntegers.isEmpty()));

        System.out.println(stackOfIntegers);
        stackOfIntegers.push(5);
        System.out.println(stackOfIntegers);
        System.out.println("isFull: " + stackOfIntegers.isFull());

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
            t =  backingArray[top - 1];
            backingArray[top-1] = null;
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
    public Integer size() {
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
