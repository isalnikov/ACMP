/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp119;

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
    public void test1() {
        String data = "4\n"
                + "10 20 30\n"
                + "7 30 00\n"
                + "23 59 59\n"
                + "13 30 30";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("7 30 0\n"
                + "10 20 30\n"
                + "13 30 30\n"
                + "23 59 59\n", outContent.toString());

    }

}
