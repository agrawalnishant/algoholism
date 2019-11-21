package com.somedomain.algos.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StairHopsTest {

    @ParameterizedTest(name = "{1} ways to climb {0} steps in hops of 1,2, and 3.")
    @CsvSource({

            "4 , 7",
            "5 , 13",
            "3 , 4"
    })
    void waysToClimbStairs(String steps, String expectedWays) {
        int result = StairHops.waysToClimbStairsInHopsOfOneTwoThree(Integer.valueOf(steps));
        assertEquals(Integer.valueOf(expectedWays), result, "Expected ways to be : " + Integer.valueOf(expectedWays) + " but was: " + result);

    }
}