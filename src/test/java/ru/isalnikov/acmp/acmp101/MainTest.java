package ru.isalnikov.acmp.acmp101;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "3 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("9", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "5 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("48", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "4 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("20", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "5 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("92", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "10 5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("562384", outContent.toString());

    }

    @Test
    public void test6() {
        String data = "10 8";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("562384", outContent.toString());

    }

}
