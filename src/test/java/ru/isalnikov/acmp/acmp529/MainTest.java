/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp529;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "3 4 8 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("5.00000", outContent.toString());

    }
}
