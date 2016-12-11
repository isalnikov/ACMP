/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp233;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "1\n"
                + "763";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("No crash", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "3\n"
                + "763 245 113";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Crash 2", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "1\n"
                + "437";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Crash 1", outContent.toString());

    }

}
