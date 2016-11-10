package ru.isalnikov.yandex;

import java.util.stream.LongStream;

public class PrimeSequence {

    public static LongStream primeSequence(long max) {
        return LongStream.iterate(2, i -> i + 1)
                .filter(x -> isPrime(x))
                .limit(max);
    }
    
    public static boolean isPrime(long x) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }

    public static void main(String[] args) {
        
        primeSequence(10).forEachOrdered(System.out::println);
    }
    
}
