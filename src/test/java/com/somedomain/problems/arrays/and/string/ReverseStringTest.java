package com.somedomain.problems.arrays.and.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @ParameterizedTest(name = "{1} is reverse of {0}")
    @CsvSource({
            "ABCCDEF,    FEDCCBA",
    })
    void reverseInplace(String sourceString, String targetReverseString) {
        ReverseString reverseString = new ReverseString();
        assertEquals(targetReverseString, reverseString.reverseInplace(sourceString), () -> targetReverseString + " should be reverse of " + sourceString);
    }

    @ParameterizedTest(name = "{1} is not reverse of {0}")
    @CsvSource({
            "ABCCDEF,    FEDCCB",
    })
    void isNotReverseInplace(String sourceString, String targetReverseString) {
        ReverseString reverseString = new ReverseString();
        assertNotEquals(targetReverseString, reverseString.reverseInplace(sourceString), () -> targetReverseString + " should not reverse of " + sourceString);
    }
}