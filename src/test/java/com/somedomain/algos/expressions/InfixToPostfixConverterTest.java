package com.somedomain.algos.expressions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfixToPostfixConverterTest {

    private String infixExpression;
    private char delimiter;

    @BeforeEach
    void setUp() {
        infixExpression = "36 / ( 4 + ( 7 - 3 ) * 2 )";
        delimiter = ' ';
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void convertToPostfix() {
        String postfixTranslation = InfixToPostfixConverter.convertToPostfix(infixExpression, delimiter);
        assertEquals("36 4 7 3 - 2 * + /", postfixTranslation);
    }

}