/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp20;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "3\n"
                + "1 2 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "5\n"
                + "1 -2 3 -4 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("5", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "12\n"
                + "5 7 6 3 4 2 7 1 8 9 4 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("7", outContent.toString());

    }
    
    @Test
    public void test4() {
        String data = "5\n"
                + "4 4 4 4 4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

}
