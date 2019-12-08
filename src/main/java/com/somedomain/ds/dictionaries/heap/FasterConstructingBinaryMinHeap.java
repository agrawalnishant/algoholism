package com.somedomain.ds.dictionaries.heap;

import com.google.common.flogger.FluentLogger;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class FasterConstructingBinaryMinHeap<T> implements Heap<T> {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    T[] listOfElements;
    Comparator<T> comparator;
    Integer limit;
    Integer currentSize = 0;
    Class<T> type;

    @Override
    public AtomicInteger getNumOpsInsert() {
        return numOpsInsert;
    }

    @Override
    public AtomicInteger getNumOpsSearch() {
        return numOpsSearch;
    }

    AtomicInteger numOpsInsert;
    AtomicInteger numOpsSearch;

    public FasterConstructingBinaryMinHeap(Class<T> type, final Integer limit, final Comparator<T> comparator) {
        this.limit = limit;
        this.comparator = comparator;
        this.type = type;
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

    @Override
    public int insert(T[] tArray) {
        this.limit = tArray.length;
        this.currentSize = this.limit;
        this.listOfElements = tArray;
        logger.atFinest().log("Pre-Heapify Copy.");
        showAll();
        for (int bubbleCounter = limit - 1; bubbleCounter >= 0; bubbleCounter--) {
            bubbleDown(bubbleCounter);
        }
        logger.atFinest().log("Post-Heapify Copy.");
        showAll();
        return limit;
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
