/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp1228;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "3 5 11";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("19\n"
                + "Yes", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "3 4 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("8\n"
                + "No", outContent.toString());

    }
    @Test
    public void test2() {
        String data = "3 5 11";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        NewMain.main(null);

        assertEquals("19\n"
                + "Yes", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "3 4 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        NewMain.main(null);

        assertEquals("8\n"
                + "No", outContent.toString());

    }

}
