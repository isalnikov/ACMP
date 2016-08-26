/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp1109;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "13";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("The next number for the number 13 is 14.\n"
                + "The previous number for the number 13 is 12.", outContent.toString());

    }

}
