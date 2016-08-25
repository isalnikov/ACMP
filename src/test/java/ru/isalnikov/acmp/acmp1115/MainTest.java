
package ru.isalnikov.acmp.acmp1115;

import ru.isalnikov.acmp.acmp1114.*;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;
/**
 * https://www.youtube.com/watch?v=mUULQEKDaO8
 *
 */
public class MainTest extends BaseTest{
    
       @Test
    public void test1() {
        String data = "7 30";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("4 2 5", outContent.toString());

    }
       @Test
    public void test2() {
        String data = "5 15";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3 0 0", outContent.toString());

    }
}
