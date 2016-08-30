package ru.isalnikov.acmp.acmp754;



import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "98 106 214";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("214", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "93 500 1000";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Error", outContent.toString());

    }
    @Test
    public void test2() {
        String data = "100 100 100";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("100", outContent.toString());

    }

}
