
package ru.isalnikov.acmp.acmp1114;

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
        String data = "60 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("12", outContent.toString());

    }
       @Test
    public void test2() {
        String data = "	-1 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("109", outContent.toString());

    }
}
