/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp903;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test1() {
        String data = "3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4", outContent.toString());

    }

    @Test
    public void test3() {
        double n = 1e6;
        
        System.err.println(n);
            n = 1e9;
        System.err.println(n);
        
    }

    @Test
    @Ignore
    public void test2() {
        String data = "10e6";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("10e6+1", outContent.toString());

    }

}
