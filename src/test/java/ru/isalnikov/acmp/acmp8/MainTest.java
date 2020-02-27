/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp8;

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
    public void test1() {
        String data = "8 54 432";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "16 19 777";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }



}
