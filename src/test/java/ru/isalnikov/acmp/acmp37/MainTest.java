package ru.isalnikov.acmp.acmp37;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "2 0.5\n"
                + "0 10 5 0\n"
                + "10 0 0 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("Yes", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "2 0.1\n"
                + "0 10 5 0\n"
                + "10 0 0 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("No", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "2 0.9\n"
                + "0 0 0 0\n"
                + "10 0 0 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("Yes", outContent.toString());

    }

}
