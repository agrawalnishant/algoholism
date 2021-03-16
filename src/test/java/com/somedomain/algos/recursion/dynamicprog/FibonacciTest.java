package com.somedomain.algos.recursion.dynamicprog;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @ParameterizedTest(name = "{0}th fibonacci numbers is {1}.")
    @CsvSource({

            "1 , 1",
            "2 , 1",
            "3 , 2",
            "5 , 5",
            "6,  8"
    })
    void generateNthFibNumWithoutMemoization(String n, String nthFibNum) {

        long result = Fibonacci.generateNthNum(Integer.valueOf(n));
        assertEquals(Long.valueOf(nthFibNum), result, "Expected Nth Fib Num to be : " + Integer.valueOf(nthFibNum) + " but was: " + result);

    }

    @ParameterizedTest(name = "Memoized {0}th fibonacci numbers is {1}.")
    @CsvSource({

            "1 , 1",
            "2 , 1",
            "3 , 2",
            "5 , 5",
            "6,  8"
    })
    void generateNthNumWithMemoization(String n, String nthFibNum) {

        long result = Fibonacci.generateNthNumWithMemoization(Integer.valueOf(n));
        assertEquals(Long.valueOf(nthFibNum), result, "Expected Memoized Nth Fib Num to be : " + Integer.valueOf(nthFibNum) + " but was: " + result);

    }


    @ParameterizedTest(name = "Memoized {0}th fibonacci numbers is {1}.")
    @CsvSource({

            "1 , 1",
            "2 , 1",
            "3 , 2",
            "5 , 5",
            "6,  8"
    })
    void generateNthNumWithLookup(String n, String nthFibNum) {

        long result = Fibonacci.generateNthNumBottomsUpOptimally(Integer.valueOf(n));
        assertEquals(Long.valueOf(nthFibNum), result, "Expected Memoized Nth Fib Num to be : " + Integer.valueOf(nthFibNum) + " but was: " + result);

    }


}