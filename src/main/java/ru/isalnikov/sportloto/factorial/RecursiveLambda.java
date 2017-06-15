package ru.isalnikov.sportloto.factorial;

import java.util.function.UnaryOperator;

/**
 *
 * @author Igor Salnikov
 */
public class RecursiveLambda {

    private static final UnaryOperator<Integer> factorial
            = (next -> next == 0 ? 1 : next * RecursiveLambda.factorial.apply(next - 1));

    public static void main(String[] args) {
        System.out.println(factorial.apply(5));
    }
}
