package ru.isalnikov.acmp.acmp67;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import org.junit.Test;

import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "2\n"
                + "255.255.255.255\n"
                + "255.255.255.0\n"
                + "3\n"
                + "192.168.31.1 192.168.31.2\n"
                + "192.168.31.3 192.168.31.4\n"
                + "192.168.31.1 192.167.31.2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("1\n"
                + "1\n"
                + "0", outContent.toString());

    }

}
