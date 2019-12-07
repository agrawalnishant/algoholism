package com.somedomain.ds.dictionaries.heap;

import java.util.List;

public interface Heap<T> {

    int insert(final T t);

    T getNextAndHeapify();


    void showAll();

    List<T> getHeap();

}
