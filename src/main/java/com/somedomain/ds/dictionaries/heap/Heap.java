package com.somedomain.ds.dictionaries.heap;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Heap<T> {

    AtomicInteger getNumOpsInsert();

    AtomicInteger getNumOpsSearch();

    int insert(final T t);
    int insert(final T[] tArray);

    T getNextAndHeapify();

    void showAll();

    List<T> getHeap();

}
