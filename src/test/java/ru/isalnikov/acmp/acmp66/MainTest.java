/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp66;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test() {
        String data = "q";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("w", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "t";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("y", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "p";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("a", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "l";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("z", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "m";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("q", outContent.toString());

    }
}
