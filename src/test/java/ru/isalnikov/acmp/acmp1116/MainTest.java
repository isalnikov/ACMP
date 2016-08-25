package ru.isalnikov.acmp.acmp1116;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 * https://www.youtube.com/watch?v=mUULQEKDaO8
 *
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "1 1 1\n"
                + "2 2 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3661", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "1 2 30\n"
                + "1 3 20";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("50", outContent.toString());

    }
}
