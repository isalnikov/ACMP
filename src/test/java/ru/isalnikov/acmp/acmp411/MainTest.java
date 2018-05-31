package ru.isalnikov.acmp.acmp411;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "1 -3 2";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("2\n"
                + "1.000000\n"
                + "2.000000", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "0 -1 6";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("1\n"
                + "6.000000", outContent.toString());

    }

}
