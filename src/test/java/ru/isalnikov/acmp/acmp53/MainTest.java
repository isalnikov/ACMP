/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp53;

import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test() {
        String data = "10 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("RED : 21\n"
                + "GREEN : 39\n"
                + "BLUE : 36\n"
                + "BLACK : 4", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "5 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

      Main.main(null);

        assertEquals("RED : 5\n"
                + "GREEN : 2\n"
                + "BLUE : 2\n"
                + "BLACK : 1", outContent.toString());

    }

}
