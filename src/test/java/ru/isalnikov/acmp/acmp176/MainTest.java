/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp176;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "3 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "37 23";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("203685956218528", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "5 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("18", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "5 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("15", outContent.toString());

    }

    @Test
    public void test5() {
        String data = "6 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("57", outContent.toString());

    }

    @Test
    public void test6() {
        String data = "6 4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("33", outContent.toString());

    }

//    @Test
//    public void test7() {
//        String data = "50 30";
//
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//
//        Main.main(null);
//
//        assertEquals("203685956218528203685956218528", outContent.toString());
//
//    }
    @Test
    public void test3_1() {
        String data = "5 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("18", outContent.toString());

    }

    @Test
    public void test4_1() {
        String data = "37 23";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("203685956218528", outContent.toString());

    }
    
    @Test
    public void test5_1() {
        String data = "50 30";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("224302049122200303870", outContent.toString());

    }

}
