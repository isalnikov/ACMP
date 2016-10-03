package ru.isalnikov.acmp.acmp224;

import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "9\n"
                + "3 5 1 7 9 0 9 -3 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("810", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "3\n"
                + "-5 -30000 -12";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-1800000", outContent.toString());

    }
}
