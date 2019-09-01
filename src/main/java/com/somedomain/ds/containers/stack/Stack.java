package com.somedomain.ds.containers.stack;

public interface Stack<T> {

    void push(T t);

    T pop();

    boolean isEmpty();

    boolean isFull();

    Integer count();


}
