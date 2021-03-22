package com.somedomain.algos.recursion;

import com.google.common.flogger.FluentLogger;

import java.util.concurrent.atomic.AtomicLong;

public class StairHops {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private final AtomicLong counter = new AtomicLong();
    private final Long[] hopsMap = new Long[100];


    public static long naiveHopscotch(int steps) {
        long numWays = 0;
        if (steps < 0) {
            numWays = 0;
        } else if (steps == 0) {
            numWays = 1;
        } else {
            numWays = naiveHopscotch(steps - 1) + naiveHopscotch(steps - 2) + naiveHopscotch(steps - 3);
        }

        return numWays;
    }


}
