package com.somedomain.algos.recursion.dynamicprog;

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
    void naiveWaysToClimbStairs(String steps, String expectedWays) {

        long result = new StairHops().naiveHopscotch(Integer.valueOf(steps));
        assertEquals(Long.valueOf(expectedWays), result, "Expected naive ways to be : " + Integer.valueOf(expectedWays) + " but was: " + result);
    }


    @ParameterizedTest(name = "{1} ways to climb {0} steps in hops of 1,2, and 3, using Memoization.")
    @CsvSource({

            "4 , 7",
            "5 , 13",
            "3 , 4"
    })
    void memoizedWaysToClimbStairs(String steps, String expectedWays) {

        long result = new StairHops().memoizedHopscotch(Integer.valueOf(steps));
        assertEquals(Long.valueOf(expectedWays), result, "Expected Memoized ways to be : " + Integer.valueOf(expectedWays) + " but was: " + result);
    }


    @ParameterizedTest(name = "{1} ways to climb {0} steps in hops of 1,2, and 3, using Tabulization.")
    @CsvSource({

            "4 , 7",
            "5 , 13",
            "3 , 4"
    })
    void tabulizedWaysToClimbStairs(String steps, String expectedWays) {

        long result = new StairHops().tabulizedHopscotch(Integer.valueOf(steps));
        assertEquals(Long.valueOf(expectedWays), result, "Expected tubulized ways to be : " + Integer.valueOf(expectedWays) + " but was: " + result);
    }

    @ParameterizedTest(name = "{1} ways to climb {0} steps in hops of 1,2, and 3, using Tabulization.")
    @CsvSource({

            "4 , 7",
            "5 , 13",
            "3 , 4"
    })
    void optimalTabulizedWaysToClimbStairs(String steps, String expectedWays) {

        long result = new StairHops().optimalTabulizedHopscotch(Integer.valueOf(steps));
        assertEquals(Long.valueOf(expectedWays), result, "Expected Optimal Space tubulized ways to be : " + Integer.valueOf(expectedWays) + " but was: " + result);
    }

}