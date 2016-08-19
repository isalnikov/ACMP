/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp36;

import java.io.ByteArrayInputStream;
import java.util.stream.LongStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "239";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("39", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "3000";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("353", outContent.toString());

    }

    public static boolean isPrime(long x) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }

    public static LongStream primeSequence(long max, long min) {
        return LongStream.iterate(2, i -> i + 1)
                .filter(x -> isPrime(x))
                .skip(min)
                .limit(max);

    }
}
