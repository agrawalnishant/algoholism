package com.somedomain.algos.sorting.divideconquer;

import com.somedomain.algos.sorting.ObjectSort;
import com.somedomain.ds.containers.queue.ArrayBackedSimpleQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeObjectSort<T> implements ObjectSort<T> {
    Class<T> type;
    private final Comparator<T> comparator;

    public MergeObjectSort(Class<T> type, final Comparator<T> comparator) {
        this.type = type;
        this.comparator = comparator;
    }

    @Override
    public void sort(LinkedList<T> list) {
        throw new UnsupportedOperationException("This method is yet to be implemented.");

    }

    @Override
    public void sort(ArrayList<T> list) {
        mergesort(list, 0, list.size() - 1);
    }

    protected void mergesort(ArrayList<T> list, int firstIndex, int lastIndex) {
        if (lastIndex > firstIndex) {
            int middle = (lastIndex - firstIndex) / 2;
            mergesort(list, firstIndex, firstIndex + middle);
            mergesort(list, firstIndex + middle + 1, lastIndex);
            merge(list, firstIndex, firstIndex + middle, lastIndex);
        }

    }

    protected void merge(ArrayList<T> list, final int firstIndex, final int middleIndex, final int lastIndex) {
        int lenOne = middleIndex - firstIndex + 1;
        int lenTwo = lastIndex - middleIndex;
        ArrayBackedSimpleQueue<T> queueOne = new ArrayBackedSimpleQueue<>(type, lenOne);
        for (int counter = firstIndex; counter <= middleIndex; counter++) queueOne.queue(list.get(counter));

        ArrayBackedSimpleQueue<T> queueTwo = new ArrayBackedSimpleQueue<>(type, lenTwo);
        for (int counter = middleIndex + 1; counter <= lastIndex; counter++) queueTwo.queue(list.get(counter));

        int listIndex = firstIndex;
        while (!queueOne.isEmpty() && !queueTwo.isEmpty()) {
            if (comparator.compare(queueOne.head(), queueTwo.head()) <= 0) {
                list.set(listIndex++, queueOne.dequeue());
            } else {
                list.set(listIndex++, queueTwo.dequeue());
            }
        }
        while (!queueOne.isEmpty()) {
            list.set(listIndex++, queueOne.dequeue());
        }

        while (!queueTwo.isEmpty()) {
            list.set(listIndex++, queueTwo.dequeue());
        }

    }
}
