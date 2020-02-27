package ru.isalnikov.acmp.acmp56;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "3\n"
                + "vasya-pupkin\n"
                + "bill-hates\n"
                + "ivan-ivanov\n"
                + "2\n"
                + "vasya-pupkin\n"
                + "destroyer";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Friends: bill-hates, ivan-ivanov, vasya-pupkin\n"
                + "Mutual Friends: vasya-pupkin\n"
                + "Also Friend of: destroyer", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "0\n"
                + "0";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Friends:\n"
                + "Mutual Friends:\n"
                + "Also Friend of:", outContent.toString());

    }
}
