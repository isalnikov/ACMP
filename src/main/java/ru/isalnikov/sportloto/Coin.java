package ru.isalnikov.sportloto;

import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class Coin {

    public static final int NUMBER = 100_000_000;

    public static int runner() {

        int res = ThreadLocalRandom
                .current()
                .ints()
                .limit(NUMBER / 4)
                .reduce(0, (int left, int right) -> left + sumBitsCounter(right));
        return res;
    }

    public static int sumBitsCounter(int i) {
        int d = Integer.bitCount(i & 0xff000000) == 3 ? 1 : 0;
        int c = Integer.bitCount(i & 0xff0000) == 3 ? 1 : 0;
        int b = Integer.bitCount(i & 0xff00) == 3 ? 1 : 0;
        int a = Integer.bitCount(i & 0xff) == 3 ? 1 : 0;
        return a + b + c + d;

    }
}
