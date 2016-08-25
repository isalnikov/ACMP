/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp39;

import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "5\n"
                + "73 31 96 24 46";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("380", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "10\n"
                + "1 2 3 4 5 6 7 8 9 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("100", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "	10\n"
                + "10 9 8 7 6 5 4 3 2 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("55", outContent.toString());

    }
}
