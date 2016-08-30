
package ru.isalnikov.acmp.acmp347;


import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "1 3 9 3 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("One Pair", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "1 5 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Two Pairs", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "1 5 2 4 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Straight", outContent.toString());

    }
    @Test
    public void test3() {
        String data = "10 11 12 13 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Nothing", outContent.toString());

    }

}
