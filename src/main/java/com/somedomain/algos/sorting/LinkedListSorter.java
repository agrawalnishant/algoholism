package com.somedomain.algos.sorting;

import java.util.LinkedList;

public interface LinkedListSorter<T> extends Sorter<T> {
    void sort(LinkedList<T> list);

}
