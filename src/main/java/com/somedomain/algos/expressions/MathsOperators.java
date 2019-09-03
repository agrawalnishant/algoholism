package com.somedomain.algos.expressions;

public enum MathsOperators {
    LEFT_PARENTHESIS('(', 8), EXPONENT('^', 4),
    MULTIPLICATION('*', 2), DIVISION('/', 2),
    ADDITION('+', 0), SUBTRACTION('-', 0),
    INVALID(' ', -1);

    private int priority;
    private char symbol;

    public int getPriority() {
        return priority;
    }

    public char getSymbol() {
        return symbol;
    }

    MathsOperators(final char symbol, final int priority) {
        this.symbol = symbol;
        this.priority = priority;

    }

    public static MathsOperators operatorFor(final char operatorSymbol) {
        switch (operatorSymbol) {
            case '(':
                return LEFT_PARENTHESIS;
            case '^':
                return EXPONENT;
            case '*':
                return MULTIPLICATION;
            case '/':
                return DIVISION;
            case '+':
                return ADDITION;
            case '-':
                return SUBTRACTION;
            default:
                return INVALID;
        }
    }
}
