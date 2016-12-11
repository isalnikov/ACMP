package ru.isalnikov.acmp.acmp81;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "5\n"
                + "5 1 6 5 9";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1 9", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "1\n"
                + "5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        assertEquals("5 5", outContent.toString());

    }
}
