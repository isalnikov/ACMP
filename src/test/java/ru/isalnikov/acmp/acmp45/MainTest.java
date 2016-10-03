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
    @Test
    public void test11() {
        String data = "0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("10", outContent.toString());

    }
    @Test
    public void test12() {
        String data = "1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }
    @Test
    public void test13() {
        String data = "90";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("259", outContent.toString());

    }
    @Test
    public void test14() {
        String data = "54";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("69", outContent.toString());

    }
    @Test
    public void test15() {
        String data = "12";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("26", outContent.toString());

    }
    @Test
    public void test16() {
        String data = "32";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("48", outContent.toString());

    }
    @Test
    public void test17() {
        String data = "24";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("38", outContent.toString());

    }
    @Test
    @Ignore
    public void test18() {
        String data = "22";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-1", outContent.toString());

    }
    @Test
        public void test19() {
        String data = "5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("5", outContent.toString());

    }
    @Test
    @Ignore
        public void test20() {
        String data = "1234";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("-1", outContent.toString());

    }
    @Test
        public void test21() {
        String data = "8192";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("28888", outContent.toString());

    }
    @Test
        public void test22() {
        String data = "13824";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("38889", outContent.toString());

    }
    @Test
    @Ignore
        public void test23() {
        String data = "143";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("13*11", outContent.toString());

    }

}
