package ru.isalnikov.yandex.fibonacci;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://habrahabr.ru/post/216049/
 *
 * Напишите реализацию класса с неблокирующим методом BigInteger next(), который
 * возвращает элементы последовательности: [1, 2, 4, 8, 16, ...]. Код должен
 * корректно работать в многопоточной среде.
 *
 */
public class FibonacciGenarator2 {

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

    public static class IntrinsicLock implements FibonacciGenerator<BigInteger> {

        private BigInteger curr = BigInteger.ONE;
        private BigInteger next = BigInteger.ONE;

        @Override
        public synchronized BigInteger next() {
            BigInteger result = curr;
            curr = next;
            next = result.add(next);
            return result;
        }

        @Override
        public synchronized BigInteger val() {
            return curr;
        }

    }

    public static void main(String[] args) {

        IntrinsicLock lock = new IntrinsicLock();

        lock.next();
    }

}
