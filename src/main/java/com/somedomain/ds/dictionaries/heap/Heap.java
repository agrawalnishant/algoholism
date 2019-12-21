package com.somedomain.ds.dictionaries.heap;

import com.somedomain.ds.HeapArrayTo2dTree;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Heap<T> {

    AtomicInteger getNumOpsInsert();

    AtomicInteger getNumOpsSearch();

    int insert(final T t);

    int insert(final T[] tArray);

    T getNextAndHeapify();

    default void showAll() {
        HeapArrayTo2dTree<T> adapter = new HeapArrayTo2dTree<T>();
        adapter.print(getHeap(), getCurrentSize());
    }

    List<T> getHeap();

    Integer getCurrentSize();

}
