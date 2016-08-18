/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp29;

import java.io.ByteArrayInputStream;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import java.util.stream.IntStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "3\n"
                + "1 5 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("9", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "	3\n"
                + "1 5 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("3", outContent.toString());

    }

    @Test
    @Ignore
    public void test2() {

        StringBuilder sb = new StringBuilder();
        sb.append("30000").append(" ");
        for (int i = 1; i <= 30000; i++) {
            sb.append(i).append(" ");
        }
        String s = IntStream.rangeClosed(1, 30000)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        sb.append(s);

        inContent = new ByteArrayInputStream(sb.toString().getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("59998", outContent.toString());

    }
}
