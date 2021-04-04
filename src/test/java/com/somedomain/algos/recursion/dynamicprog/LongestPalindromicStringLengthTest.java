package com.somedomain.algos.recursion.dynamicprog;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicStringLengthTest {

    @ParameterizedTest(name = "Length of Longest Palindrome in string {0} is {1}.")
    @CsvSource({

            "dxyfgxndmxa, 3",
            "abcddcba, 4",
            "abca, 2",
            "abc, 1",
            "a, 1",
            "ab, 1",


    })
    void lengthLongestPalindromeNaive(String firstString, int maxPalindromeLen) {

        int result = LongestPalindromicStringLength.lengthLongestPalindromeNaive(firstString);
        assertEquals(Long.valueOf(maxPalindromeLen), result,
                "Naive: Expected Length of longest palindrome to be : " + Integer.valueOf(maxPalindromeLen) + " but was: " + result);

    }
}