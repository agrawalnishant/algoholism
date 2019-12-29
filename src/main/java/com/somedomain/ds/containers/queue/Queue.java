package com.somedomain.ds.containers.queue;

public interface Queue<T> {

    int NO_HOPE = -1;

    int queue(final T t);

    T dequeue();

    int count();

    boolean isEmpty();

    T head();

}
