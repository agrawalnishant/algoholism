package com.somedomain.algos.recursion.dynamicprog;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackTest {
    final static int[] weightArray = new int[]{2, 3, 5, 7, 8};
    final static int[] valueArray = new int[]{5, 7, 8, 10, 11};

    @ParameterizedTest(name = "Max Knapsack Value is {1} for max Weight {0}.")
    @CsvSource({

            "20 , 33",
            "15 , 25"
    })
    void chooseMaxValue(String maxAllowedWeight, String maxKnapsackValue) {
        long result = Knapsack.chooseMaxValue(weightArray, valueArray, Integer.valueOf(maxAllowedWeight), 0);
        assertEquals(Long.valueOf(maxKnapsackValue), result, "Expected MaxValue is : " + Integer.valueOf(maxKnapsackValue) + " but was: " + result);

    }


    @ParameterizedTest(name = "Max Knapsack Value is {1} for max Weight {0}, using Memoization.")
    @CsvSource({

            "20 , 33",
            "15 , 25"
    })
    void memoizeMaxValue(String maxAllowedWeight, String maxKnapsackValue) {
        long result = Knapsack.memoizeMaxValue(weightArray, valueArray, Integer.valueOf(maxAllowedWeight), 0);
        assertEquals(Long.valueOf(maxKnapsackValue), result, "Expected MaxValue is : " + Integer.valueOf(maxKnapsackValue) + " but was: " + result);

    }

    @ParameterizedTest(name = "Max Knapsack Value is {1} for max Weight {0}, using BottomsUp Table.")
    @CsvSource({

            "20 , 33",
            "15 , 25"
    })
    void tabulizeMaxValue(String maxAllowedWeight, String maxKnapsackValue) {
        long result = Knapsack.tabulizeMaxValue(weightArray, valueArray, Integer.valueOf(maxAllowedWeight));
        assertEquals(Long.valueOf(maxKnapsackValue), result, "Expected MaxValue is : " + Integer.valueOf(maxKnapsackValue) + " but was: " + result);

    }


}