package com.somedomain.algos;

import com.google.common.flogger.FluentLogger;
import com.somedomain.ds.containers.stack.ArrayBackedStack;

public class TowerOfHanoi {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private static int moveCounter;

    private static ArrayBackedStack<Character> source = new ArrayBackedStack<Character>(Character.class, 10);
    private static ArrayBackedStack<Character> intermediate = new ArrayBackedStack<Character>(Character.class, 10);
    private static ArrayBackedStack<Character> destination = new ArrayBackedStack<Character>(Character.class, 10);

    public static void main(String[] args) {
        TowerOfHanoi.init();
        TowerOfHanoi.move(source.count(), source, intermediate, destination);
        TowerOfHanoi.showTotalMoves();
    }

    private static void init() {
        source.push('J');
        source.push('I');
        source.push('H');
        source.push('G');
        source.push('F');
        source.push('E');
        source.push('D');
        source.push('C');
        source.push('B');
        source.push('A');

    }

    private static void showTotalMoves() {
        logger.atFine().log("Total moves: " + moveCounter);
    }

    private static void move(int top, ArrayBackedStack<Character> source, ArrayBackedStack<Character> intermediate, ArrayBackedStack<Character> destination) {
        ++moveCounter;
        if (top == 1) {
            destination.push(source.pop());
        } else {
            //Move n-1 tree from source to intermediate.
            move(top - 1, source, destination, intermediate);

            // Move nth element from source to destination.
            destination.push(source.pop());

            //Move n-1 tree from intermediate to destination.
            move(top - 1, intermediate, source, destination);
        }
    }
}
