package com.somedomain.algos.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoliceThievesTest {

    @ParameterizedTest(name = "Max thrives that can be caught in arrangement {0} are {1}.")
    @CsvSource({

            "PTTPT, 2",
            "TPPPTTTTTTTTTPTP, 5",
            "PPPP, 0",
            "TTTT, 0"
    })
    void policeThief(final String arrangement, int maxThieves) {
        int result = PoliceThieves.policeThief(arrangement.toCharArray(), maxThieves);
        assertEquals(Long.valueOf(maxThieves), result,
                "Expected thieves caught to be : " + Integer.valueOf(maxThieves) + " but was: " + result);

    }
}