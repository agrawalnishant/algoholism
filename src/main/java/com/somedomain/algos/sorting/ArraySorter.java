package com.somedomain.algos.sorting;

import com.somedomain.algos.sorting.Sorter;

import java.util.ArrayList;

public interface ArraySorter<T> extends Sorter<T> {
    void sort(ArrayList<T> list);

}
