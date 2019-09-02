package com.somedomain.algos.expressions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostfixEvaluatorTest {


    private PostfixEvaluator postfixEvaluator;
    final MathContext mathContext = MathContext.DECIMAL32;

    @BeforeEach
    void setUp() {
        postfixEvaluator = new PostfixEvaluator(mathContext);
    }

    @AfterEach
    void tearDown() {
        postfixEvaluator = null;
    }

    @Test
    void evaluate() {
        final String inputExpression = "7 6 5 4 + * -";
        char delimiter = ' ';
        BigDecimal expectedResult = new BigDecimal("-47", mathContext);
        BigDecimal actualResult = postfixEvaluator.evaluate(inputExpression, delimiter);
        assertEquals(expectedResult, actualResult);

    }
}