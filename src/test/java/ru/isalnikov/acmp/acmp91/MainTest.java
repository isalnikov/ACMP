/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp91;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 * 
 * an { 2, 3, 4, 7, 13, 15,18..., }
 * 
 * bn = {1,5,6,8,9,10,11,12,14,16,17,19,21,.... } 
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("7\n8", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("25\n"
                + "16", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("13\n"
                + "9", outContent.toString());

    }
    @Test
    public void test6() {
        String data = "6";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("15\n"
                + "10", outContent.toString());

    }
    @Test
    public void test7() {
        String data = "7";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("18\n"
                + "11", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "6578";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("19731\n"
                + "9868", outContent.toString());

    }
    @Test
    public void test4() {
        String data = "10000";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("29995\n"
                + "15000", outContent.toString());

    }
}
