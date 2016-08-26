package ru.isalnikov.acmp.acmp92;

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

        assertEquals("1 4 1", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "24";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4 16 4", outContent.toString());

    }

    @Test
    public void test5() {
        String data = "60";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("10 40 10", outContent.toString());

    }

}
