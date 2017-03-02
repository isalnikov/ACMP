package ru.isalnikov.acmp.acmp55;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "1 2\n"
                + "3 4\n"
                + "2\n"
                + "22";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "1 1\n"
                + "100 100\n"
                + "1\n"
                + "7";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }

}
