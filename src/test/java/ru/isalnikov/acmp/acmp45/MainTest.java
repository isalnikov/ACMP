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
    @Test
    public void test6() {
        String data = "24";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("38", outContent.toString());

    }
    @Test
    
    public void test7() {
        String data = "2048";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4888", outContent.toString()); //22222222222

    }
    @Test
    public void test8() {
        String data = "9765625";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("5555555555", outContent.toString());

    }
    @Test
    public void test9() {
        String data = "976562500";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4555555555555", outContent.toString());

    }
    @Test
    public void test10() {
        String data = "13824";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("38889", outContent.toString());

    }

}
