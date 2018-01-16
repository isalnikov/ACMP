package ru.isalnikov.sportloto;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class Coin {

    public static final int NUMBER = 100_000_000;
    public static final int count = 3;

    public static int runner() {

        int res = 0;
        for (int i = 0; i < NUMBER / 4; i++) {
            res += sumBitsCounter(ThreadLocalRandom.current().nextInt());

        }

//        int res = ThreadLocalRandom
//                .current()
//                .ints()
//                .limit(NUMBER / 4)
//                .reduce(0, (left, right) -> left + sumBitsCounter(right));
        return res;
    }

    public static int sumBitsCounter(int i) {
        int result = 0;

        if (count == Integer.bitCount(i & 0xff000000)) {
            ++result;
        }
        if (count == Integer.bitCount(i & 0x00ff0000)) {
            ++result;
        }
        if (count == Integer.bitCount(i & 0x0000ff00)) {
            ++result;
        }
        if (count == Integer.bitCount(i & 0x000000ff)) {
            ++result;
        }
        return result;

    }
}
