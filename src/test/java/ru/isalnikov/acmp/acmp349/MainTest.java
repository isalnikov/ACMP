/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp349;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "2 5";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2\n"
                + "3\n"
                + "5\n", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Absent\n", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "2 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2\n", outContent.toString());

    }

    @Test
    public void test3() {
        int m = 19;
        int n = 101;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf( n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

    @Test
    public void test4() {
        int m = 4;
        int n = 4;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

    @Test
    public void test5() {
        int m = 2;
        int n = 5;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }
    @Test
    public void test6() {
        int m = 999979;
        int n = 1_000_000;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

}
