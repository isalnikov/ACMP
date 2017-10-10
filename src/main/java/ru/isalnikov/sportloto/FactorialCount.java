package ru.isalnikov.sportloto;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class FactorialCount {

    public static BigInteger streamedParallel(int n) {
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

    public static void main(String[] args) {

        System.out.println(streamedParallel(100).toString());
        System.out.println(streamedParallel(100).toString().length());
    }
}
