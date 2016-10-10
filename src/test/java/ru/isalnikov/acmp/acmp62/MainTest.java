/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp62;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.acmp62.Main.Result;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "C3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("BLACK", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "G8";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("WHITE", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "A1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("BLACK", outContent.toString());

    }

    @Test
    public void testDesk() {

        String letters = "ABCDEFGH";
        String numbers = "12345678";

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String key = "" + letters.charAt(i) + numbers.charAt(j);
                Result result = ((i + j) & 1) == 0 ? Result.BLACK : Result.WHITE;
                map.put(key, result.toString());

            }

        }

        System.err.println(map);

    }

}
