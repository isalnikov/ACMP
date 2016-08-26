/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp822;


import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;


public class MainTest extends BaseTest {


    @Test
    public void test1() {
        String data = "2 1 2 4 6 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("6", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "0 0 0 3 3 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4.5", outContent.toString());

    }



}
