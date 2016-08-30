package ru.isalnikov.acmp.acmp1117;

import java.io.ByteArrayInputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("9 45", outContent.toString());

    }
    @Test
    public void test2() {
        String data = "2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("10 35", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("11 35", outContent.toString());

    }
    @Test
    public void test4() {
        String data = "4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("12 25", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "5";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("13 25", outContent.toString());

    }
    
    @Test
    public void test10() {
        String data = "10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("17 55", outContent.toString());

    }
    @Test
    public void test() {
        LocalTime localTime = LocalTime.of(9, 0);
        System.err.println(localTime);
        System.err.println( localTime.format(DateTimeFormatter.ofPattern("HH mm")));
        localTime = localTime.plusMinutes(15).plusMinutes(45);
        System.err.println( localTime.format(DateTimeFormatter.ofPattern("HH mm")));

    }

}
