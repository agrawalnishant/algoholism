package com.somedomain.algos.recursion;

import com.google.common.flogger.FluentLogger;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class TraverseGrid {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private HashMap<Point, Integer> cache = new HashMap<Point, Integer>();
    private AtomicInteger iterations = new AtomicInteger(0);

    public int traverse(final Point source, final Point destination) {
        int numPaths = countPaths(source, destination);
        printCachedPaths();
        return numPaths;
    }

    private int countPaths(final Point source, final Point dest) {

        Integer pathNum = cache.size() > 0 && cache.get(source) != null ? cache.get(source) : 0;

        if (pathNum != null && pathNum != 0) {
            return pathNum;
        } else {
            pathNum = 0;
        }
        iterations.getAndIncrement();
        if (source.getX() < dest.getX()) {
            Point nextPoint = new Point(source);
            nextPoint.translate(1, 0);
            int count = countPaths(nextPoint, dest);
            cache.put(nextPoint, count);
            pathNum += count;
        }
        if (source.getY() < dest.getY()) {
            Point nextPoint = new Point(source);
            nextPoint.translate(0, 1);
            int count = countPaths(nextPoint, dest);
            cache.put(nextPoint, count);
            pathNum += count;
        }
        if (source.getX() == dest.getX() && source.getY() == dest.getY()) {
            pathNum = 1;
        }

        return pathNum;
    }

    private void printCachedPaths() {
        for (Iterator<Point> it = cache.keySet().iterator(); it.hasNext(); ) {
            Point nextPt = it.next();
            logger.atFinest().log("Key: " + nextPt + ", Value: " + cache.get(nextPt));
        }
    }
}
