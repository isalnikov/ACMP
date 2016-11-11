/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp360;

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
        String data = "3\n"
                + "1 1 1\n"
                + "2 2 1\n"
                + "2 1 0";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("6", outContent.toString());

    }
    @Test
    public void test1() {
        String data = "3\n"
                + "1 1 1\n"
                + "2 2 1\n"
                + "2 1 0";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("6", outContent.toString());

    }
    @Test
    public void test7() {
        String data = "3\n"
                + "1 1 1\n"
                + "2 2 1\n"
                + "2 1 0";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main7.main(null);

        assertEquals("6", outContent.toString());

    }
    @Test
    public void test8() {
 

      //  inContent = new ByteArrayInputStream(data.getBytes());
      //  System.setIn(inContent);

        Main8.main(null);

      //  assertEquals("6", outContent.toString());

    }
}
