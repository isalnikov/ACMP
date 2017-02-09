
package ru.isalnikov.acmp.acmp54;

import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 *
 */
public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test() {
        String data = "3 3\n"
                + "4 -1 -3\n"
                + "-2 1 3\n"
                + "0 2 -3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-2 2", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "3 4\n"
                + "-1 0 2 1\n"
                + "-2 0 1 0\n"
                + "2 1 -1 -2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-1 1", outContent.toString());

    }

}
