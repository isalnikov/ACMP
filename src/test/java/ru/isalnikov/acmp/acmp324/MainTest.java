/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp324;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import static ru.isalnikov.acmp.acmp32.Main.stringSwap;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "6116";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "1231";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }

}
