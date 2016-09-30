
package ru.isalnikov.acmp.acmp200;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;


public class MainTest extends BaseTest{
    
   
    @Test
    public void test1() {
        String data = "5 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());
    }
   
    @Test
    public void test2() {
        String data = "100 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("24", outContent.toString());
    }
    @Test
    public void test3() {
        String data = "100 6";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("48", outContent.toString());
    }
    
    @Test
    public void test4() {
        String data = "3 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("0", outContent.toString());
    }
    @Test
    public void test5() {
        String data = "1000 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("249", outContent.toString());
    }
    
    @Test
    public void test6() {
        String data = "10 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());
    }
    
}
