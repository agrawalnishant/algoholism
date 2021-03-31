package com.somedomain.algos.recursion.dynamicprog;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubstringTest {

    @ParameterizedTest(name = "Length of Longest Common Substrings in {0} and {1} is {2}.")
    @CsvSource({

            "zabcd , xbc, 2",
            "xabcdefghij , yabddefgz, 4",
            "abcdefghij , jihgfedcba, 1",
            "xa , , 0",

    })
    void maxLengthNaive(String firstString, String secondString, int maxCommLen) {

        int result = LongestCommonSubstring.maxLengthNaive(firstString, secondString);
        assertEquals(Long.valueOf(maxCommLen), result, "Expected Naive Max Common Sub-string Length is : " + Integer.valueOf(maxCommLen) + " but was: " + result);

    }

    @ParameterizedTest(name = "Length of Longest Common Substrings in {0} and {1} is {2}.")
    @CsvSource({

            "zabcd , xbc, 2",
            "xabcdefghij , yabddefgz, 4",
            "abcdefghij , jihgfedcba, 1",
            "xa , , 0",

    })
    void maxLengthMemoized(String firstString, String secondString, int maxCommLen) {
        int result = LongestCommonSubstring.maxLengthMemoized(firstString, secondString);
        assertEquals(Long.valueOf(maxCommLen), result, "Expected Memoized Max Common Sub-string Length is : " + Integer.valueOf(maxCommLen) + " but was: " + result);

    }

    @ParameterizedTest(name = "Length of Longest Common Substrings in {0} and {1} is {2}.")
    @CsvSource({

            "zabcd , xbc, 2",
            "xabcdefghij , yabddefgz, 4",
            "abcdefghij , jihgfedcba, 1",
            "xa , , 0",

    })
    void maxLengthTabulized(String firstString, String secondString, int maxCommLen) {
        int result = LongestCommonSubstring.maxLengthTabulized(firstString, secondString);
        assertEquals(Long.valueOf(maxCommLen), result, "Expected Tabulized Max Common Sub-string Length is : " + Integer.valueOf(maxCommLen) + " but was: " + result);

    }


}