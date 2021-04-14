package com.somedomain.algos.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DutchNationalFlagTest {


    @ParameterizedTest(name = "Max Knapsack Value is {1} for max Weight {0}.")
    @CsvSource({

            "0 0 1 1 0 1 2 0 1 0 1 2 2 0 1 , 0 0 0 0 0 0 1 1 1 1 1 1 2 2 2",
            "0 1 2, 0 1 2",
            "0 1 1 2 1 2, 0 1 1 1 2 2",
    })
    void sortForDutchNationalFlag(String input, String expected) {
        int[] result = DutchNationalFlag.sort(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray());
        int[] expectedArr = Arrays.stream(expected.split(" ")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(expectedArr, result, "Expected flag to look like : " + expected + " but was: " + Arrays.toString(result));

    }
}