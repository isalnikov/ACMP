/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp17;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "13\n"
                + "5 3 1 3 5 2 5 3 1 3 5 2 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("6", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "4\n"
                + "1 2 3 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "4\n"
                + "1 1 1 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "5\n"
                + "1 2 1 1 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4", outContent.toString());

    }

    @Test
    public void test5() {
        String data = "22\n"
                + "1 2 3 1 2 3 4 1 2 3 1 2 3 4 1 2 3 1 2 3 4 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("7", outContent.toString());

    }

    @Test
    public void test9() {
        String data = "5\n"
                + "1 2 1 1 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4", outContent.toString());

    }

    @Test
    @Ignore
    public void test7() {
        String data = "7\n"
                + "1 2 1 3 1 2 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("6", outContent.toString());

    }

    @Test
    @Ignore
    public void test8() {
        String data = "8\n"
                + "1 2 2 1 1 2 2 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("7", outContent.toString());

    }

    @Test
    public void test10() {
        String data = "11 \n"
                + "1 2 1 1 2 1 2 1 1 2 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("5", outContent.toString());

    }
}
