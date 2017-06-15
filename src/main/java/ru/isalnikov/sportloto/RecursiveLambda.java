package ru.isalnikov.sportloto;

/**
 *
 * @author Igor Salnikov
 */
public class RecursiveLambda {

    private static final java.util.function.UnaryOperator<Integer> 
            factorial = (t -> t == 0 ? 1 : t * RecursiveLambda.factorial.apply(t - 1));

    public static void main(String[] args) {
        System.out.println(factorial.apply(5));
    }
}
