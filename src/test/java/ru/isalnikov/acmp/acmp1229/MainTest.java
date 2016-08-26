/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp1229;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "0 3 0 0 5 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("Yes", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "0 0 1 5 2 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("No", outContent.toString());

    }

}
