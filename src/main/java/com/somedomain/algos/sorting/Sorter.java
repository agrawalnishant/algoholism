package com.somedomain.algos.sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Sorter<T> {

    void sort(LinkedList<T> list);

    void sort(ArrayList<T> list);

}
