//http://introcs.cs.princeton.edu/java/43stack/Evaluate.java
//http://eddmann.com/posts/shunting-yard-implementation-in-java/
//https://rosettacode.org/wiki/Parsing/Shunting-yard_algorithm
package ru.isalnikov.yandex;

import java.util.*;

public class ShuntingYard {

    public static void main(String[] args) {
        System.out.println(postfix("( 5 + 7 ) * 2")); // 5 7 + 2 *
        System.out.println(postfix("5 + 7 / 2"));     // 5 7 2 / +
    }

    private enum Operator {

        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    private static Map<String, Operator> ops = new HashMap<String, Operator>() {
        {
            put("+", Operator.ADD);
            put("-", Operator.SUBTRACT);
            put("*", Operator.MULTIPLY);
            put("/", Operator.DIVIDE);
        }
    };

    private static boolean isHigerPrec(String op, String sub) {
        return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
    }

    public static String postfix(String infix) {
        StringBuilder output = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for (String token : infix.split("\\s")) {
            // operator
            if (ops.containsKey(token)) {
                while (!stack.isEmpty() && isHigerPrec(token, stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                stack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();

                // digit
            } else {
                output.append(token).append(' ');
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString();
    }

}
