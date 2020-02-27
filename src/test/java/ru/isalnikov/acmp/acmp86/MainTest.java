/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp86;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class MainTest extends BaseTest {


    @Test
    public void test1() {
        String data = "3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }
}
