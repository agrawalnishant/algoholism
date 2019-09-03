package com.somedomain.algos.expressions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfixEvaluatorTest {
    final MathContext mathContext = MathContext.DECIMAL32;
    private PostfixEvaluator postfixEvaluator;
    private String infixExpression;
    private char delimiter;

    @BeforeEach
    void setUp() {
        infixExpression = "36 / ( 4 + ( 7 - 3 ) * 2 )";
        delimiter = ' ';
        postfixEvaluator = new PostfixEvaluator(mathContext);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void evaluateInfixExpression() {
        String postfixTranslation = InfixToPostfixConverter.convertToPostfix(infixExpression, delimiter);
        BigDecimal expectedResult = new BigDecimal("3", mathContext);
        BigDecimal actualResult = postfixEvaluator.evaluate(postfixTranslation, delimiter);
        assertEquals(expectedResult, actualResult);
    }
}
