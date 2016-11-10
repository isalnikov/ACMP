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

    static class LockFree implements FibonacciGenerator<BigInteger> {

        // Инкапсулируем состояние генератора в класс
        private static class State {

            final BigInteger next;
            final BigInteger curr;

            public State(BigInteger curr, BigInteger next) {
                this.next = next;
                this.curr = curr;
            }
        }

        // Сделаем состояние класса атомарным
        private final AtomicReference<State> atomicState = new AtomicReference<>(
                new State(BigInteger.ONE, BigInteger.ONE));

        @Override
        public BigInteger next() {
            BigInteger value = null;
            while (true) {
                // сохраняем состояние класса 
                State state = atomicState.get();
                // то что возвращаем если удалось изменить состояние класса
                value = state.curr;
                // конструируем новое состояние
                State newState = new State(state.next, state.curr.add(state.next));
            // если за время пока мы конструировали новое состояние
                // оно осталось прежним, то заменяем состояние на новое,
                // иначе пробуем сконструировать еще раз
                if (atomicState.compareAndSet(state, newState)) {
                    break;
                }
            }
            return value;
        }

        @Override
        public BigInteger val() {
            return atomicState.get().curr;
        }
    }

    public static void main(String[] args) {

        LockFree lock = new LockFree();

        lock.next();
    }

}
