
package ru.isalnikov.acmp.acmp178;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class Main1Test extends BaseTest{
    
    @Test
    public void test1() {
        String data = "7\n"
                + "1 2 3 2 3 1 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("1 3 3 1 2 2 2", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "8 \n"
                + "1 2 3 2 3 1 2 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("2 3 2 3 2 1 1 1", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "3 \n"
                + "1 2 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("2 3 1", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "20 \n"
                + "1000000 1000000 1000000 1000000 1000000 \n"
                + "1000000 -1000000 1000000 1000000 1000000 \n"
                + "1000000 1000000 -1000000 1000000 1000000 \n"
                + "1000000 1000000 1000000 -1000000 -1000000";

        String result = "-1000000 -1000000 -1000000 -1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals(result, outContent.toString());

    }

    @Test
    public void test5() {
        String data = "3\n"
                + "-9 9 -1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("9 -1 -9", outContent.toString());

    }

    @Test
    public void test6() {
        String data = "3\n"
                + "-1 -2 -3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("-1 -2 -3", outContent.toString());

    }

    @Test
    public void test7() {
        String data = "6\n"
                + "-2 -3 -1 -1 0 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("-2 -3 0 0 -1 -1", outContent.toString());

    }
    
}
