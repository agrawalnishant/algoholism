package com.somedomain.problems.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UniqueTest {

    @ParameterizedTest(name = "{0} has Unique characters")
    @CsvSource({
            "ABCDEF,    true",
    })
    void hasAllUniqueChars(String sourceString, Boolean isUnique) {
        Unique unique = new Unique();
        assertEquals(isUnique, unique.hasAllUniqueChars(sourceString), () -> sourceString + "has duplicate Characters also.");
    }

    @ParameterizedTest(name = "{0} has duplicate characters")
    @CsvSource({
            "ABCCDEF,    false",
    })
    void hasAllDuplicateChars(String sourceString, Boolean isUnique) {
        Unique unique = new Unique();
        assertEquals(isUnique, unique.hasAllUniqueChars(sourceString), () -> sourceString + "has duplicate Characters also.");
    }
}