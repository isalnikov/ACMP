package ru.isalnikov.acmp.acmp41;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "3\n"
                + "9 -20 14";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-20 9 14 ", outContent.toString());

    }

    @Test
    @Ignore
    public void test1_2() {
        String data = "3\n"
                + "9 -20 14";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main2.main(null);

        assertEquals("-20 9 14 ", outContent.toString());

    }

    @Test
    @Ignore
    public void test1__2() {
        String data = "3\n"
                + "9 -20 14";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main2.main(null);

        assertEquals("-20 9 14 ", outContent.toString());

    }

    @Test
    public void test11_2() {
        String data = "10\n"
                + "12 7 92 5 18 4 32 48 11 74";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main11.main(null);

        assertEquals("4 5 7 11 12 18 32 48 74 92 ", outContent.toString());

    }

    @Test
    @Ignore
    public void test4_2() {
        String data = "10\n"
                + "12 7 92 5 18 4 32 48 11 74";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main4.main(null);

        assertEquals("4 5 7 11 12 18 32 48 74 92 ", outContent.toString());

    }

    @Test
    @Ignore
    public void test21() {
        String data = "3\n"
                + "9 -20 14";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main21.main(null);

        assertEquals("-20 9 14 ", outContent.toString());

    }

    @Test
    public void test111() {
        String data = "3\n"
                + "9 -20 14";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main111.main(null);

        assertEquals("-20 9 14 ", outContent.toString());

    }

    @Test
    public void test1111() {
        String data = "1\n"
                + "-20";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main111.main(null);

        assertEquals("-20 ", outContent.toString());

    }

    @Test
    public void test11112() {
        String data = "10\n"
                + "12 7 92 5 18 4 32 48 11 74";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main111.main(null);

        assertEquals("4 5 7 11 12 18 32 48 74 92 ", outContent.toString());

    }
}
