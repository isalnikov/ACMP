package ru.isalnikov.acmp.acmp69;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "3 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "239 566";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }

}
