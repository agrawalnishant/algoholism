package com.somedomain.problems.arrays.and.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @ParameterizedTest(name = "{1} is anagram of {0}")
    @CsvSource({
            "ABCDEF,    ABEFDC, true"
    })
    void areAnagrams(String sourceString, String testString, Boolean isAnagram) {
        Anagram anagram = new Anagram();
        assertEquals(isAnagram, anagram.areAnagrams(sourceString, testString), () -> testString + " is not anagram of " + sourceString);

    }

    @ParameterizedTest(name = "{1} is not anagram of {0}")
    @CsvSource({
            "ABCCDEF,    ABEDC, false",
            "ABCEF,    ABEDC, false"
    })
    void areNotAnagrams(String sourceString, String testString, Boolean isAnagram) {
        Anagram anagram = new Anagram();
        assertEquals(isAnagram, anagram.areAnagrams(sourceString, testString), () -> testString + " should not be anagram of " + sourceString);

    }
}