/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp27;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "5 5\n"
                + "2\n"
                + "1 1 3 3\n"
                + "2 2 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("18", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "6 7\n"
                + "3\n"
                + "0 0 5 5\n"
                + "1 1 4 4\n"
                + "2 2 3 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("17", outContent.toString());

    }

}
