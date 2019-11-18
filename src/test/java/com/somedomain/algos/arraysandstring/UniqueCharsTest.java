package com.somedomain.algos.arraysandstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCharsTest {

    @ParameterizedTest(name = "{0} has Unique characters")
    @CsvSource({
            "ABCDEF,    true",
    })
    void hasAllUniqueChars(String sourceString, Boolean isUnique) {
        UniqueChars uniqueChars = new UniqueChars();
        assertEquals(isUnique, uniqueChars.hasAllUniqueChars(sourceString), () -> sourceString + "has duplicate Characters also.");
    }

    @ParameterizedTest(name = "{0} has duplicate characters")
    @CsvSource({
            "ABCCDEF,    false",
    })
    void hasAllDuplicateChars(String sourceString, Boolean isUnique) {
        UniqueChars uniqueChars = new UniqueChars();
        assertEquals(isUnique, uniqueChars.hasAllUniqueChars(sourceString), () -> sourceString + "has duplicate Characters also.");
    }
}