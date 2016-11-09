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
public class FibonacciGenarator3 {

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

    static class FineGrainedLock implements FibonacciGenerator<BigInteger> {

        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private BigInteger curr = BigInteger.ONE;
        private BigInteger next = BigInteger.ONE;

        @Override
        public BigInteger next() {
            BigInteger result;
            lock.writeLock().lock();
            try {
                // Вход другим потокам запрещен
                result = curr;
                curr = next;
                next = result.add(next);
                return result;
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public BigInteger val() {
            lock.readLock().lock();
            try {
            // При отпущенном write lock
                // Допуст`им вход множества потоков
                return curr;
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {

        FineGrainedLock lock = new FineGrainedLock();

        lock.next();
    }

}
