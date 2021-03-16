package com.somedomain.algos.recursion;

import com.google.common.flogger.FluentLogger;

import java.util.concurrent.atomic.AtomicLong;

public class StairHops {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private final AtomicLong counter = new AtomicLong();
    private final Long[] hopsMap = new Long[100];

    public long waysToClimbSteps(final int numberOfSteps) {
        return waysToClimbStairsInHopsOfOneTwoThree(numberOfSteps);
    }

    public long waysToClimbStairsInHopsOfOneTwoThree(final int steps) {
        counter.getAndIncrement();
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else {
            {
                long result = 0;
                if (hopsMap[steps] != null && hopsMap[steps] != 0) {
                    logger.atFinest().log("Got from Map [" + steps + ", " + hopsMap[steps] + "] --- [" + counter.getAndIncrement() + "] ----> result: " + result);
                    return hopsMap[steps];

                } else {

                    result = waysToClimbStairsInHopsOfOneTwoThree(steps - 1)
                            + waysToClimbStairsInHopsOfOneTwoThree(steps - 2)
                            + waysToClimbStairsInHopsOfOneTwoThree(steps - 3);
                    logger.atFinest().log("Put into Map[" + steps + ", " + result + "] --- [" + counter.getAndIncrement() + "] ----> result: " + result);
                    hopsMap[steps] = result;

                }

                return result;

            }
        }
    }

}
