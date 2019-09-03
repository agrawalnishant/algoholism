package com.somedomain.algos.expressions;

import com.google.common.flogger.FluentLogger;
import com.somedomain.ds.containers.stack.ArrayBackedStack;

public class InfixToPostfixConverter {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    public static void main(String[] args) {
        logger.atFinest().log("*** ###### Hello World!   #####  ****");

    }


    public static String convertToPostfix(final String infixExpression, final char delimiter) {
        StringBuilder targetPostfixExpression = new StringBuilder("");

        if (infixExpression != null && infixExpression.length() > 3) {
            String[] tokens = infixExpression.trim().split(String.valueOf(delimiter));
            int numberOfTokens = tokens.length;
            ArrayBackedStack<String> operandStack = new ArrayBackedStack<>(String.class, numberOfTokens);
            int tokenPointer = 0;
            while (tokenPointer < numberOfTokens) {
                String token = tokens[tokenPointer];
                char firstCharOfToken = token.charAt(0);
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
                        targetPostfixExpression.append(token).append(delimiter);
                        break;
                    }
                    case '-':
                    case '+':
                    case '*':
                    case '/':
                    case '^': {
                        int priority = MathsOperators.operatorFor(firstCharOfToken).getPriority();
                        String nextInStack = operandStack.peek();
                        int nextOperandPriority = nextInStack == null ? -1 : MathsOperators.operatorFor(nextInStack.charAt(0)).getPriority();
                        while (nextInStack != null && !nextInStack.equals("(") && nextOperandPriority > priority) {
                            targetPostfixExpression.append(nextInStack).append(delimiter);
                            operandStack.pop(); // Remove current from Stack.
                            nextInStack = operandStack.peek();
                            nextOperandPriority = nextInStack == null ? -1 : MathsOperators.operatorFor(nextInStack.charAt(0)).getPriority();
                        }
                        operandStack.push(token);
                        break;
                    }
                    case '(': {
                        operandStack.push(token);
                        break;
                    }
                    case ')': {
                        String nextInStack = operandStack.pop();
                        while (!nextInStack.equals("(")) {
                            targetPostfixExpression.append(nextInStack).append(delimiter);
                            nextInStack = operandStack.pop();
                        }
                        break;
                    }

                }
                tokenPointer++;
            }
            targetPostfixExpression.append(operandStack.pop());
        }
        return targetPostfixExpression.toString();

    }
}
