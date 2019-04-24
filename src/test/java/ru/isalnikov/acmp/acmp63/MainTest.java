package ru.isalnikov.acmp.acmp63;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2 2", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "5 6";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2 3", outContent.toString());

    }


}

