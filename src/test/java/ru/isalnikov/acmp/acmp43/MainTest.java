/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp43;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "00101110000110";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4", outContent.toString());

    }

    @Test
    public void test7() {
        String data = "1111111110";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test1_1() {
        String data = "00101110000110";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("4", outContent.toString());

    }

    @Test
    public void test7_1() {
        String data = "1111111110";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("1", outContent.toString());

    }
}
