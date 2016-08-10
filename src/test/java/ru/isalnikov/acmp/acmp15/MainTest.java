
package ru.isalnikov.acmp.acmp15;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;


public class MainTest extends BaseTest{
    
   
    @Test
    public void test1() {
        String data = "5\n"
                + "0 1 0 0 0\n"
                + "1 0 1 1 0\n"
                + "0 1 0 0 0\n"
                + "0 1 0 0 0\n"
                + "0 0 0 0 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3", outContent.toString());

    }
}
