package com.somedomain.algos.recursion.dynamicprog;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualPartitionsTest {
    @ParameterizedTest(name = "Partitioning test successful for Set: {0}, Result: \"{1}\" using Brute-Force DP.")
    @CsvSource({

            "7 2 3 4 9 6 18 1, true",
            "1 2 3, true",
            "7 2 3 4 9 6 18 2, false",
            "7 2 3 4, false",
            "7, false",
            "8, false"



    })
    void hasEqualPartitionsBruteForce(String testArrayString, String expectedResult) {
        String[] elements = testArrayString.split(" ");
        int[] numArray = Stream.of(elements).mapToInt(Integer::parseInt).toArray();

        boolean result = EqualPartitions.naiveCheck(numArray);
        assertEquals(Boolean.valueOf(expectedResult), result, "Expected Array Partitioning possible : " + Boolean.valueOf(expectedResult) + " but was: " + result);

    }

    @ParameterizedTest(name = "Partitioning test successful for Set: {0}, Result: \"{1}\" using Memoization.")
    @CsvSource({

            "7 2 3 4 9 6 18 1, true",
            "1 2 3, true",
            "7 2 3 4 9 6 18 2, false",
            "7 2 3 4, false",
            "7, false",
            "8, false"


    })
    void hasEqualPartitionsMemoized(String testArrayString, String expectedResult) {
        String[] elements = testArrayString.split(" ");
        int[] numArray = Stream.of(elements).mapToInt(Integer::parseInt).toArray();

        boolean result = EqualPartitions.memoizedCheck(numArray);
        assertEquals(Boolean.valueOf(expectedResult), result, "Memoized Expected Array Partitioning possible : " + Boolean.valueOf(expectedResult) + " but was: " + result);

    }


}