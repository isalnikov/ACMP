/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp10;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test1() {
        String data = "1 -3 0 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("0 3", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "3 -15 18 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("0 2 3", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "1 -7 -33 135";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-5 3 9", outContent.toString());

    }

}
