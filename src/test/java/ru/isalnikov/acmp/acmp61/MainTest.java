package ru.isalnikov.acmp.acmp61;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "26 17\n"
                + "13 15\n"
                + "19 11\n"
                + "14 16";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "14 15\n"
                + "17 18\n"
                + "20 20\n"
                + "15 17";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "15 16\n"
                + "18 17\n"
                + "10 12\n"
                + "14 12";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("DRAW", outContent.toString());

    }

}
