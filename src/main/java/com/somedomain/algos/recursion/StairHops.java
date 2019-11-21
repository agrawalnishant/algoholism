package com.somedomain.algos.recursion;

import com.google.common.flogger.FluentLogger;

import java.util.concurrent.atomic.AtomicInteger;

public class StairHops {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private static AtomicInteger counter = new AtomicInteger();

    public static int waysToClimbStairsInHopsOfOneTwoThree(final int steps) {
        counter.getAndIncrement();
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else {
            {
                int result = waysToClimbStairsInHopsOfOneTwoThree(steps - 1)
                        + waysToClimbStairsInHopsOfOneTwoThree(steps - 2)
                        + waysToClimbStairsInHopsOfOneTwoThree(steps - 3);
                //logger.atFinest().log("[" + counter.getAndIncrement() + "] ----> result: " + result);
                return result;

            }
        }
    }

}
