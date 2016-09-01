package ru.isalnikov.acmp.acmp45;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("25", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "13";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-1", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "90";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("259", outContent.toString());

    }

}
