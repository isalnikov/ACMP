/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp35;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "4\n"
                + "2 0\n"
                + "13 20\n"
                + "5 23\n"
                + "18 6";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("44344\n"
                + "48134\n"
                + "45699\n"
                + "49458\n", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "2\n"
                + "15 20\n"
                + "1000 26000";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("48767\n"
                + "1340237\n", outContent.toString());

    }
    
    @Test
    public void test3(){
        System.err.println(10<<1);
        System.err.println(10<<2);
        System.err.println(10<<3);
        System.err.println(10<<4);
        System.err.println(10<<5);
        
        System.err.println(100>>1);
    }

}
