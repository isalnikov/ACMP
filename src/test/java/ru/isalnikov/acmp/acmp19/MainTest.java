/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp19;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest{
    
    @Test
    public void test9() {
        String data = "D1 D3 E5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("29", outContent.toString());

    }
    
    @Test
    public void test1() {
        String data = "D3 D1 E5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("32", outContent.toString());

    }
    @Test
    public void test3() {
        String data = "D4 D3 E4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("31", outContent.toString());

    }
    
    @Test
    public void test4() {
        String data = "A1 B2 C3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("33", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "A7 E5 H2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("34", outContent.toString());

    }
    @Test
    public void test6() {
        String data = "H8 H7 H6";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("27", outContent.toString());

    }
    @Test
    public void test7() {
        String data = "E8 E7 E6";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("28", outContent.toString());

    }
    @Test
    public void test8() {
        String data = "D4 D3 E4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("31", outContent.toString());

    }
    
    
//10010000
//12100000
//11010000
//21111111
//11112111
//10100000
//10010000
//10001000
    
    @Test
    //https://lichess.org/editor/8/8/8/4R3/Q7/8/1N6/8_w_KQkq_-
    public void test10() {
        String data = "A4 E5 B2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        System.out.println(outContent.toString());
        assertEquals("32", outContent.toString());

    }
    
}
