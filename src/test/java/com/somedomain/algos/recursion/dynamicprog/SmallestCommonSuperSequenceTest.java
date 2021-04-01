package com.somedomain.algos.recursion.dynamicprog;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestCommonSuperSequenceTest {


    @ParameterizedTest(name = "Length of Smallest Common SuperSequence of {0} and {1} is {2}.")
    @CsvSource({

            "abcd , cdef, abcdef",
            "abcd , efgh, abcdefgh",
            "abcd , abcd, abcd",
            "abcdef , xabcd, abcdefxabcd"


    })
    void scsNaive(String firstString, String secondString, String expectedResult) {

        String result = SmallestCommonSuperSequence.findSCS(firstString, secondString);
        assertEquals(expectedResult, result, "Expected Naive Shortest Common SuperSequence : " + expectedResult + " but was: " + result);
    }
}