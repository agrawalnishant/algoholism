package com.somedomain.algos.expressions;

import com.somedomain.ds.containers.stack.ArrayBackedStack;

import java.math.BigDecimal;
import java.math.MathContext;

public final class PostfixEvaluator {

    final MathContext mathContext;

    public PostfixEvaluator(final MathContext mathContext) {
        this.mathContext = mathContext;
    }

    public BigDecimal evaluate(String inputExpression, char delimiter) {
        BigDecimal result = null;
        if (inputExpression != null && inputExpression.length() > 3) {
            String[] tokens = inputExpression.trim().split(String.valueOf(delimiter));
            int numberOfTokens = tokens.length;
            ArrayBackedStack<String> expressionStack = new ArrayBackedStack<>(String.class, numberOfTokens);
            int tokenPointer = 0;
            while (tokenPointer < numberOfTokens) {
                String nextToken = tokens[tokenPointer++];
                char firstCharOfToken = nextToken.charAt(0);
                switch (firstCharOfToken) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9': {
                        expressionStack.push(nextToken);
                        break;
                    }
                    case '-': {
                        BigDecimal operand2 = new BigDecimal(expressionStack.pop(), mathContext);
                        BigDecimal operand1 = new BigDecimal(expressionStack.pop(), mathContext);
                        String tmpResult = String.valueOf(operand1.subtract(operand2, mathContext));
                        expressionStack.push(tmpResult);
                        break;
                    }
                    case '+': {
                        BigDecimal operand2 = new BigDecimal(expressionStack.pop(), mathContext);
                        BigDecimal operand1 = new BigDecimal(expressionStack.pop(), mathContext);
                        String tmpResult = String.valueOf(operand1.add(operand2, mathContext));
                        expressionStack.push(tmpResult);
                        break;
                    }
                    case '*': {
                        BigDecimal operand2 = new BigDecimal(expressionStack.pop(), mathContext);
                        BigDecimal operand1 = new BigDecimal(expressionStack.pop(), mathContext);
                        String tmpResult = String.valueOf(operand1.multiply(operand2, mathContext));
                        expressionStack.push(tmpResult);
                        break;
                    }
                    case '/': {
                        BigDecimal operand2 = new BigDecimal(expressionStack.pop(), mathContext);
                        BigDecimal operand1 = new BigDecimal(expressionStack.pop(), mathContext);
                        String tmpResult = String.valueOf(operand1.divide(operand2, mathContext));
                        expressionStack.push(tmpResult);
                        break;
                    }
                }
            }
            result = new BigDecimal(expressionStack.pop(), mathContext);
        }
        return result;
    }


}
