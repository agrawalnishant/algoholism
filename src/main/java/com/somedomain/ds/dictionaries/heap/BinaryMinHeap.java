package com.somedomain.ds.dictionaries.heap;

import com.google.common.flogger.FluentLogger;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class BinaryMinHeap<T> implements Heap<T> {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    T[] listOfElements;
    Comparator<T> comparator;
    Integer limit;
    Integer currentSize = 0;
    AtomicInteger numOpsInsert;
    AtomicInteger numOpsSearch;

    public BinaryMinHeap(Class<T> type, final Integer limit, final Comparator<T> comparator) {
        this.limit = limit;
        this.comparator = comparator;
        listOfElements = (T[]) Array.newInstance(type, limit);
        numOpsInsert = new AtomicInteger();
        numOpsSearch = new AtomicInteger();
    }

    @Override
    public int insert(final T t) {
        listOfElements[currentSize] = t;
        numOpsInsert.getAndIncrement();
        if (currentSize != 0) {
            bubbleUp(currentSize);
        }
        return ++currentSize;

    }

    private void bubbleUp(Integer position) {
        if (position == 0) {
            return;
        } else {
            T current = listOfElements[position];
            T parent = listOfElements[((position - 1) / 2)];
            if (comparator.compare(current, parent) < 0) {
                swapPositions(position, ((position - 1) / 2));
                numOpsInsert.getAndIncrement();
                bubbleUp(((position - 1) / 2));
            }
        }
    }

    private void swapPositions(final int currentPos, final int parentPos) {
        T tmp = listOfElements[parentPos];
        listOfElements[parentPos] = listOfElements[currentPos];
        listOfElements[currentPos] = tmp;
    }

    @Override
    public T getNextAndHeapify() {
        T min = listOfElements[0];
        listOfElements[0] = listOfElements[currentSize - 1];
        listOfElements[currentSize - 1] = null;
        --currentSize;
        numOpsSearch.getAndIncrement();
        bubbleDown(0);
        return min;
    }

    public void bubbleDown(final int currentPosition) {
        int minIndex = currentPosition;
        for (int counter = currentPosition + 1; counter < currentSize; counter++) {
            T minElement = listOfElements[minIndex];
            T nextElement = listOfElements[counter];
            if (nextElement != null && comparator.compare(minElement, nextElement) > 0) {
                minIndex = counter;
            }
        }
        if (minIndex != currentPosition) {
            numOpsSearch.getAndIncrement();
            swapPositions(currentPosition, minIndex);
            bubbleDown(minIndex);
        }

    }

    @Override
    public void showAll() {
        logger.atFinest().log(Arrays.toString(listOfElements));
    }

    @Override
    public List<T> getHeap() {
        return Arrays.asList(listOfElements);
    }
}
