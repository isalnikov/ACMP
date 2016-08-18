/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp188;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("0", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "5";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("44", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "20";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("895014631192902121", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "15";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("481066515734", outContent.toString());

    }
    
     public static BigInteger factorial(int n) {
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
     
    public static long subfactorial(int n) {
        return Math.round(factorial(15).longValue() / Math.E);
    }
    
    @Test
    public void test6() {
        System.err.println(subfactorial(15));
    }
    @Test
    public void test7() {
        System.err.println(factorial(20));
    }

}
