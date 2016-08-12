/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp326;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "7\n"
                + "1 2 3 2 3 1 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1 3 3 1 2 2 2", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "3\n"
                + "-9 9 -1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("9 -1 -9", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "3\n"
                + "-1 -2 -3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-1 -2 -3", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "6\n"
                + "-2 -3 -1 -1 0 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-2 -3 0 0 -1 -1", outContent.toString());

    }

}
