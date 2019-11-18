package com.somedomain.algos.numbers;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;

public class PrimeNumberGenerator {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public int[] generatePrimeNumbersUpto(final int limit) {

        // 0. Create an array to store prime numbers of length = 25% of limit, which is more than density of primes ( x / lnx -1 = ~ 0.16)
        int[] primes = new int[limit / 4];
        int primesFound = 0;
        // 1. Create a boolean array from 0 to limit, and initialize elements by True.
        // As we flag them as non-Prime, we flip flg to False.

        boolean[] primeCandidates = new boolean[limit + 1];
        for (int index = 0; index <= limit; index++) {
            primeCandidates[index] = true;
        }

        // 2. Start from 2 until square-root of limit, and flip all its multiples until limit to False.
        // Find next prime by moving to next non-prime number, and use this to flip its multiples.

        int nextPrime = 2;
        int maxPrimeDivisor = Double.valueOf(Math.sqrt(limit)).intValue();
        while (nextPrime < maxPrimeDivisor) {
            for (int multiples = 2 * nextPrime; multiples < limit; multiples += nextPrime) {
                primeCandidates[multiples] = false;
            }
            primes[primesFound++] = nextPrime;
            //Find next prime, and use that as divisor in next iteration.
            for (int index = nextPrime + 1; index <= limit; index++) {
                if (index == limit) {
                    break;
                } else if (primeCandidates[index] == false) {
                    continue;
                } else {
                    nextPrime = index;
                    break;
                }
            }
        }
        for (int index = nextPrime + 1; index < limit; index++) {
            if (primeCandidates[index] == true)
                primes[primesFound++] = index;
        }
        logger.atFine().log("Found Primes : " + Arrays.toString(primes));
        return primes;
    }
}
