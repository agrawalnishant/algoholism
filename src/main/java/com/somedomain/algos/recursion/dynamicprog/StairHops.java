package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class StairHops {

    public static final int EMPTY = -1;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private static Integer[] hopsMap = null;
    private final AtomicLong counter = new AtomicLong();

    public StairHops() {
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
            Arrays.fill(hopsMap, EMPTY);
        }
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else if (hopsMap[steps] != EMPTY) {
            return hopsMap[steps];
        } else {
            numWays = memoizedHopscotch(steps - 1) + memoizedHopscotch(steps - 2) + memoizedHopscotch(steps - 3);
            hopsMap[steps] = numWays;
            return numWays;
        }

    }

    public static int tabulizedHopscotch(int steps) {
        if (hopsMap == null) {
            hopsMap = new Integer[steps + 1];
            Arrays.fill(hopsMap, EMPTY);
        }
        hopsMap[0] = 1;
        hopsMap[1] = 1;
        hopsMap[2] = 2;
        for (int count = 3; count <= steps; count++) {
            hopsMap[count] = hopsMap[count - 1] + hopsMap[count - 2] + hopsMap[count - 3];
        }
        return hopsMap[steps];
    }

    public static int optimalTabulizedHopscotch(int steps) {
        if (hopsMap == null) {
            hopsMap = new Integer[steps + 1];
            Arrays.fill(hopsMap, EMPTY);
        }
        int hopCount0 = 1;
        int hopCount1 = 1;
        int hopCount2 = 2;
        int currentHopCount = 0;
        for (int count = 3; count <= steps; count++) {
            currentHopCount = hopCount2 + hopCount1 + hopCount0;
            hopsMap[count] = currentHopCount;
            hopCount0 = hopCount1;
            hopCount1 = hopCount2;
            hopCount2 = currentHopCount;
        }
        return hopsMap[steps];
    }

}
