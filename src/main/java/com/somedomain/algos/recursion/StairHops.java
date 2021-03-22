package com.somedomain.algos.recursion;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class StairHops {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private static Integer[] hopsMap = null;
    private final AtomicLong counter = new AtomicLong();

    public StairHops(){
        hopsMap = null;
    }

    public static int naiveHopscotch(int steps) {
        int numWays = 0;
        if (steps < 0) {
            numWays = 0;
        } else if (steps == 0) {
            numWays = 1;
        } else {
            numWays = naiveHopscotch(steps - 1) + naiveHopscotch(steps - 2) + naiveHopscotch(steps - 3);
        }

        return numWays;
    }

    public static int memoizedHopscotch(int steps) {
        int numWays = 0;
        if (hopsMap == null) {
            hopsMap = new Integer[steps + 1];
            Arrays.fill(hopsMap, -1);
        }
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else if (hopsMap[steps] != -1) {
            return hopsMap[steps];
        } else {
            numWays = memoizedHopscotch(steps - 1) + memoizedHopscotch(steps - 2) + memoizedHopscotch(steps - 3);
            hopsMap[steps] = numWays;
            return numWays;
        }

    }

}
