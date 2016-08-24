/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp38;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    @Ignore
    public void test() {
        String data = "14\n"
                + "13 33 31 35 74 12 45 67 93 43 7 66 95 91";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "4\n"
                + "3 2 5 4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "	6\n"
                + "5 5 5 5 5 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("0", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "9\n"
                + "2 1 3 2 9 1 2 3 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "10\n"
                + "2 5 3 12 4 6 13 7 1 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

}
