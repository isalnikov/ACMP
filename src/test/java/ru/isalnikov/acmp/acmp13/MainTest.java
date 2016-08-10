/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp13;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;


public class MainTest extends BaseTest{
    
    @Test
    public void test1() {
        String data = "5671 7251";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1 2", outContent.toString());

    }
    
    @Test
    public void test2() {
        String data = "1234 1234";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4 0", outContent.toString());

    }
    
    @Test
    public void test3() {
        String data = "2034 6234";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2 1", outContent.toString());

    }
    
}
