/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp1227;


import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest{

    @Test
    public void test() {
        String data = "3 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3", outContent.toString());

    }
    @Test
    public void test1() {
        String data = "7 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("35", outContent.toString());

    }
    
    @Test
    public void test2() {

        System.err.println(Main.factorial(20));
        System.err.println(Main.factorial(2));
        System.err.println(Main.factorial(1));
        System.err.println(Main.factorial(0));
        System.err.println(Main.factorial(5));
    }
    
}
