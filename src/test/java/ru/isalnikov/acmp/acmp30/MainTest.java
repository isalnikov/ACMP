package ru.isalnikov.acmp.acmp30;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "23:59:58\n"
                + "23:59:59";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("0\n"
                + "0\n"
                + "2\n"
                + "2\n"
                + "0\n"
                + "4\n"
                + "0\n"
                + "0\n"
                + "1\n"
                + "3", outContent.toString());

    }

    @Test
    public void test5() {
        String data = "23:59:58\n"
                + "23:59:58";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("0\n"
                + "0\n"
                + "1\n"
                + "1\n"
                + "0\n"
                + "2\n"
                + "0\n"
                + "0\n"
                + "1\n"
                + "1", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "13:24:09\n"
                + "13:24:40";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("5\n"
                + "45\n"
                + "45\n"
                + "45\n"
                + "36\n"
                + "3\n"
                + "3\n"
                + "3\n"
                + "3\n"
                + "4", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "00:00:00\n"
                + "00:00:00";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("6\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "0", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "00:59:59\n"
                + "01:00:00";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("7\n"
                + "1\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "2\n"
                + "0\n"
                + "0\n"
                + "0\n"
                + "2", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "00:00:00\n"
                + "23:59:59";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("92880\n"
                + "92880\n"
                + "71280\n"
                + "56880\n"
                + "53280\n"
                + "53280\n"
                + "24480\n"
                + "24480\n"
                + "24480\n"
                + "24480", outContent.toString());

    }

}
