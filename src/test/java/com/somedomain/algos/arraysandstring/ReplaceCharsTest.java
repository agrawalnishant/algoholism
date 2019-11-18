package com.somedomain.algos.arraysandstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReplaceCharsTest {

    @Test
    void replaceAll() {
        char[] testString = "hello cat dog world.      ".toCharArray();
        char[] replacement = "%20".toCharArray();
        ReplaceChars replaceChars = new ReplaceChars();
        replaceChars.replaceAll(testString, ' ', replacement, "hello cat dog world.".length());
        assertTrue(new String("hello%20cat%20dog%20world.").equals(new String(testString)), "After Inplacement replacement it hsould be like Hello%20cat%20dog%20world");
    }
}