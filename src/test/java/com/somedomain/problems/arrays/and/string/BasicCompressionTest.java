package com.somedomain.problems.arrays.and.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCompressionTest {

    @ParameterizedTest(name = "{1} is compressed form of {0}")
    @CsvSource({
            "aabcccd,    a2b1c3d1",
            "abcd,    abcd",
            "a,    a",
            "ab,    ab"
    })
    void compress(String sourceString, String compressedString) {
        BasicCompression compression = new BasicCompression();
        String result = compression.compress(sourceString);
        System.out.println("sourceString: " + sourceString + ", result: " +  result);
        assertTrue(result.equals(compressedString), "Compressed form is wrong.");

    }
}