/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp7;

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
        String data = "5 7 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("7", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "987531 234 86364";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("987531", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "189285 283 4958439238923098349024";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4958439238923098349024", outContent.toString());

    }

}
