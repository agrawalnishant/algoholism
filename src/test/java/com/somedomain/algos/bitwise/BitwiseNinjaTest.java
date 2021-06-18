package com.somedomain.algos.bitwise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwiseNinjaTest {

    @Test
    void findMissingNumber() {
        int[] arr = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11};
        int result = BitwiseNinja.findMissingNumber(arr);
        assertEquals(3, result, "Missing Number in " + Arrays.toString(arr) + " should be 3.");
    }

    @Test
    void findNonDuplicateNumber() {
        int[] arr = {1, 2, 4, 2, 1, 4, 6, 5, 6, 5, 3};
        int result = BitwiseNinja.findNonDuplicateNumber(arr);
        assertEquals(3, result, "Non-Duplicate Number in " + Arrays.toString(arr) + " should be 3.");
    }

    @Test
    void findHammingDistance() {
        int result = BitwiseNinja.findHammingDistance(17, 2);
        assertEquals(3, result, "Hamming distance between 16 : " + BitwiseNinja.convertToBits(17) + " and 2: " + BitwiseNinja.convertToBits(2) + "is 3");
    }

    @Test
    void countNumberOfBits() {
        int result = BitwiseNinja.countNumberOfBits(9);
        assertEquals(4, result, "Number of bits until Most Significant Bit should be 4 but is " + result);
    }

    @Test
    void convertToBits() {
        String result = BitwiseNinja.convertToBits(23);
        assertEquals("00000000000000000000000000010111", result, "23 to bits should be 10111, but is " + result);
    }

    @ParameterizedTest(name = "Is {0} power of 2: {1}")
    @CsvSource({"16,  true", "17,  false"})
    void isPowerOfTwo(String number, String isPowerOfTwo) {
        Integer numberInt = Integer.valueOf(number);
        Boolean expectedResult = Boolean.valueOf(isPowerOfTwo);
        Boolean result = BitwiseNinja.isPowerOfTwo(numberInt);
        assertEquals(result, expectedResult, numberInt + " is power of 2 should be :" + expectedResult);
    }
}