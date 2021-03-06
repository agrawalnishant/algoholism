package com.somedomain.ds;

import com.google.common.flogger.FluentLogger;
import com.somedomain.ds.containers.stack.ArrayBackedStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private ArrayBackedStack integerStack;

    @BeforeEach
    private void init() {
        integerStack = new ArrayBackedStack<Integer>(Integer.class, 5);
    }

    @Test
    public void testPush() {
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        logger.atFine().log("############# " + integerStack + " #############");
        assertEquals(",1,2,3,4,null", integerStack.toString(), "Stack has these elements:" + integerStack.toString());
    }

    @Test
    public void testPop() {
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        assertTrue(integerStack.pop().equals(4));
        assertEquals(",1,2,3,null,null", integerStack.toString());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(integerStack.isEmpty());
    }

    @Test
    public void testIsFull() {

        integerStack = new ArrayBackedStack<Integer>(Integer.class, 1);
        integerStack.push(1);
        assertTrue(integerStack.isFull());
    }

    @Test
    public void testCount() {
        integerStack.push(1);
        assertEquals(1, integerStack.count());
        integerStack.push(2);
        assertEquals(2, integerStack.count(), integerStack.toString());
        integerStack.pop();
        assertEquals(1, integerStack.count());
        integerStack.pop();
        assertEquals(0, integerStack.count());
        assertTrue(integerStack.isEmpty());

    }

}
