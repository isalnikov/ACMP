package ru.isalnikov.acmp.acmp412;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;
import static ru.isalnikov.acmp.base.BaseTest.input;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "d3 d5 d8";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "a1 a8 b3";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }
    
    @Test
    public void test3() {
        String data = "a1 a8 h8";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }
    @Test
    public void test13() {
        String data = "c3 a1 e5";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }
    @Test
    public void test14() {
        String data = "a3 b3 c3";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }
    @Test
    public void test15() {
        String data = "c2 b3 d1";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }
    
    
    @Test
    public void test4() {
        String data = "h8 e5 a1";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }
    
    @Test
    public void test5() {
         String data = "d5 d3 d8";

        System.setIn(input(data));

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }

}
