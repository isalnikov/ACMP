package ru.isalnikov.acmp.acmp44;


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
        String data = "<<<<>>--><--<<--<<>>>--><<<<<";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4", outContent.toString());

    }
    @Test
    public void test2() {
        String data = ">>-->";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }
    @Test
    public void test3() {
        String data = "<--<<";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }
    @Test
    public void test4() {
        String data = "<--<<--<<";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "<--<";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("0", outContent.toString());

    }
    @Test
    public void test6() {
        String data = ">>-->>-->";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }
    @Test
    public void test7() {
        String data = ">>>-->>>-->";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }
    @Test
    public void test8() {
        String data = "";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("0", outContent.toString());

    }
    @Test
    @Ignore
    public void test9() {
        String data = null;

        System.setIn(new ByteArrayInputStream(null));

        Main.main(null);

        assertEquals("0", outContent.toString());

    }

  
}
