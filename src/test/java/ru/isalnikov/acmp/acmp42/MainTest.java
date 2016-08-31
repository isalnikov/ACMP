package ru.isalnikov.acmp.acmp42;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "6";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("9", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "8";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("18", outContent.toString());

    }
    @Test
    public void test3() {
        String data = "13";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("108", outContent.toString());

    }
}
