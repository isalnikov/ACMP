package ru.isalnikov.acmp.acmp70;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "abc\n"
                + "3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("abcabcabc", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "abcdabcd\n"
                + "-2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("abcd", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "abcd\n"
                + "-4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO SOLUTION", outContent.toString());

    }

    @Test
    public void test4() {
        String s = "abcdabcd";
        int k = Math.abs(-2);
        int n = s.length() / k;
        String[] ar = "abcdabcd".split("(?<=\\G.{" + n + "})");
        System.err.println(Arrays.toString(ar));

    }

}
