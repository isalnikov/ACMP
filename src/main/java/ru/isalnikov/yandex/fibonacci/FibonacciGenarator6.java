package ru.isalnikov.yandex.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://stackoverflow.com/questions/19278443/how-do-i-use-the-new-computeifabsent-function
 *
 *
 *
 */
public class FibonacciGenarator6 {

    private static Map<Integer, Long> memo = new HashMap<>();

    static {
        memo.put(0, 0L); //fibonacci(0)
        memo.put(1, 1L); //fibonacci(1)
    }

    public static long fibonacci(int x) {
        return memo.computeIfAbsent(x, n -> fibonacci(n - 2) + fibonacci(n - 1));
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

}
