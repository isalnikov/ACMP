package ru.isalnikov.acmp.acmp294;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "1000 10 100\n"
                + "1200 20 90";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("37000", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "5000 15 23\n"
                + "4000 17 22";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("53600", outContent.toString());

    }

}
