package ru.isalnikov.yandex.fibonacci;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://habrahabr.ru/post/216049/
 *
 * Напишите реализацию класса с неблокирующим методом BigInteger next(), который
 * возвращает элементы последовательности: [1, 2, 4, 8, 16, ...]. Код должен
 * корректно работать в многопоточной среде.
 *
 */
public class FibonacciGenarator5 {

    public interface FibonacciGenerator<T> {

        /**
         * Следующее сгенерированное значение
         */
        T next();

        /**
         * Текущее значение в генераторе
         */
        public T val();
    }

    static class Immutable {

        private final BigInteger next;
        // Текущее значение
        public final BigInteger val;

        private Immutable(BigInteger next, BigInteger val) {
            this.next = next;
            this.val = val;
        }

        public Immutable next() {
            return new Immutable(val.add(next), next);
        }

        public static Immutable first() {
            return new Immutable(BigInteger.ONE, BigInteger.ONE);
        }

    }

    public static void main(String[] args) {

      Immutable immutable =  Immutable.first();
        for (int i = 0; i < 10; i++) {
            immutable = immutable.next();
            System.out.println(immutable.val.toString());
            
        }

    }

}
