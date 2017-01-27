package ru.isalnikov.acmp.acmp50;

import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "abcabc\n"
                + "abc";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("4", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "abcabc\n"
                + "acb";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("0", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "aaaaaaa\n"
                + "aa";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("6", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "aAaa8aaAa\n"
                + "aAa";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("4", outContent.toString());

    }
}
