package ru.isalnikov.acmp.acmp67;

import ru.isalnikov.acmp.acmp67.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.Test;

import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {


    @Test
    public void test1() {
        String data = "3\n"
                + "1 4 11";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("271", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "5\n"
                + "2 5 6 8 12";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("31139", outContent.toString());

    }

}
