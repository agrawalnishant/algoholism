package com.somedomain.algos.sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.somedomain.algos.Utility.createArray;
import static com.somedomain.algos.Utility.print;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingTest {

    private static int[] integerArray;

    private static int[] sortedArray;

    @BeforeAll
    public static void init() {
        int arrayLength = 100;
        integerArray = createArray(arrayLength, false);
        sortedArray = integerArray.clone();
        Arrays.sort(sortedArray);
        // integerArray = sortedArray;

    }

    @Test
    public void testPartitioning() {
        int[] integerArray = this.integerArray.clone();
        print(integerArray, "Input to partition: ");
        print(integerArray, "Output from Partition: ");

    }

    @Test
    public void testInsertionSort() {
        int[] integerArray = this.integerArray.clone();
        print(integerArray, null);
        long startTime = System.nanoTime();
        new InsertionSort().sort(integerArray);
        long endTime = System.nanoTime();
        print(integerArray, null);
        assertArrayEquals(sortedArray, integerArray);

    }

    @Test
    public void testSelectionSort() {

        int[] integerArray = this.integerArray.clone();
        print(integerArray, null);
        long startTime = System.nanoTime();
        new SelectionSort().sort(integerArray);
        long endTime = System.nanoTime();
        print(integerArray, null);
        assertArrayEquals(sortedArray, integerArray);
    }

    @Test
    public void testBubbleSort() {
        int[] integerArray = this.integerArray.clone();
        print(integerArray, null);
        long startTime = System.nanoTime();
        new BubbleSort().sort(integerArray);
        long endTime = System.nanoTime();
        print(integerArray, null);
        assertArrayEquals(sortedArray, integerArray);
    }

    @Test
    public void testCombBubbleSort() {
        int[] integerArray = this.integerArray.clone();
        print(integerArray, null);
        long startTime = System.nanoTime();
        new CombBubbleSort().sort(integerArray);
        long endTime = System.nanoTime();
        print(integerArray, null);
        assertArrayEquals(sortedArray, integerArray);
    }

}
