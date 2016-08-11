/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp178;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "7\n"
                + "1 2 3 2 3 1 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1 3 3 1 2 2 2", outContent.toString());

    }
    
    @Test
    public void test3() {
        String data = "8 \n"
                + "1 2 3 2 3 1 2 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2 3 2 3 2 1 1 1", outContent.toString());

    }
    @Test
    public void test4() {
        String data = "3 \n"
                + "1 2 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2 3 1", outContent.toString());

    }
    

    @Test
    public void test2() {
        String data = "20 \n"
                + "1000000 1000000 1000000 1000000 1000000 \n"
                + "1000000 -1000000 1000000 1000000 1000000 \n"
                + "1000000 1000000 -1000000 1000000 1000000 \n"
                + "1000000 1000000 1000000 -1000000 -1000000";

        String result = "-1000000 -1000000 -1000000 -1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals(result, outContent.toString());

    }

}
