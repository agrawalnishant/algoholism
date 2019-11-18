package com.somedomain.algos.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumberGeneratorTest {

    @Test
    void generatePrimeNumbersUpto() {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
        int primesUpto = 100;
        String expectedResultString = "2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97";
        int[] actualPrimes = primeNumberGenerator.generatePrimeNumbersUpto(primesUpto);
        String actualPrimesString = Arrays.toString(actualPrimes);
        assertTrue(actualPrimesString.indexOf(expectedResultString) != -1, () -> "Expected Primes to contain " + expectedResultString + " but had " + actualPrimesString);
    }
}