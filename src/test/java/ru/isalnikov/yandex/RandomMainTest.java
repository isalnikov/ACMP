/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class RandomMainTest {

    private final static double EPSILON = 0.01;

    public static boolean equals(double a, double b) {
        return a == b ? true : Math.abs(a - b) < EPSILON;
    }

    public RandomMainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRand2() {
        RandomMain rm = new RandomMain();
        int count = 100_000_000;
        HashMap<Integer, AtomicInteger> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int next = rm.rand2();

            map.putIfAbsent(next, new AtomicInteger(0));
            map.get(next).incrementAndGet();

        }

        System.out.println(map);
        double value = 2.0 * (map.get(0).get()) / (count);
        System.out.println(value);
        assertTrue(equals(value, 1.0));

    }

    @Test
    public void testSetbit() {
        int b = 0;
        
        b<<=1;
        System.out.println(String.format("%08d",b));
        
         System.out.println(String.format("%08x",55));
        b<<=1;
        System.out.println(Integer.toBinaryString(b));
    }

    /**
     * Test of rand3_1 method, of class RandomMain.
     */
    @Test
    public void testRand3_1() {

        RandomMain rm = new RandomMain();
        int count = 100_000_000;
        HashMap<Integer, AtomicInteger> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int next = rm.rand3_1();

            map.putIfAbsent(next, new AtomicInteger(0));
            map.get(next).incrementAndGet();

        }

        System.out.println(map);
        double value = 3.0 * (map.get(0).get()) / (count);
        System.out.println(value);
        assertTrue(equals(value, 1.0));

    }

}
