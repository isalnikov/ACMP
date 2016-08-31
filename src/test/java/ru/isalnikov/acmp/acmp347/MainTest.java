
package ru.isalnikov.acmp.acmp347;


import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {
    
    
    
    @Test
    public void test_1() {
        String data = "1 3 9 3 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("One Pair", outContent.toString());

    }
    

    @Test
    public void test() {
        String data = "1 3 9 3 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("One Pair", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "1 5 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Two Pairs", outContent.toString());

    }
    @Test
    public void test2_1() {
        String data = "1 5 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Two Pairs", outContent.toString());

    }
    @Test
    public void test2_1_1() {
        String data = "1 1 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Two Pairs", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "1 5 2 4 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Straight", outContent.toString());

    }
    @Test
    public void test2_1_2() {
        String data = "1 5 2 4 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Straight", outContent.toString());

    }
    @Test
    public void test3() {
        String data = "10 11 12 13 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Nothing", outContent.toString());

    }
    @Test
    public void test3_1() {
        String data = "10 11 12 13 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Nothing", outContent.toString());

    }
    
    @Test
    public void test4() {
        String data = "10 10 10 10 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Impossible", outContent.toString());

    }
    @Test
    public void test4_1() {
        String data = "10 10 10 10 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Impossible", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "10 10 10 10 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Four of a Kind", outContent.toString());

    }
    @Test
    public void test5_1() {
        String data = "10 10 10 10 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Four of a Kind", outContent.toString());

    }
    @Test
    public void test5_1_2() {
        String data = "1 10 10 10 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Four of a Kind", outContent.toString());

    }
    @Test
    public void test5_1_3() {
        String data = "1 1 1 1 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Four of a Kind", outContent.toString());

    }
    
    @Test
    public void test6_1() {
        String data = "10 10 10 1 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Full House", outContent.toString());

    }
    @Test
    public void test6_1_2() {
        String data = "1 10 10 10 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Full House", outContent.toString());

    }
    
    @Test
    public void test6_1_3() {
        String data = "2 2 3 3 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Full House", outContent.toString());

    }
    @Test
    public void test6_1_4() {
        String data = "2 2 2 3 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Full House", outContent.toString());

    }
    
    @Test
    public void test6_1_5() {
        String data = "3 2 2 3 3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Full House", outContent.toString());

    }
    
    @Test
    public void test6() {
        String data = "10 10 10 1 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Full House", outContent.toString());

    }
    @Test
    public void test7() {
        String data = "3 4 5 6 7";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Straight", outContent.toString());

    }
    
    @Test
    public void test8() {
        String data = "3 4 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Three of a Kind", outContent.toString());

    }
    @Test
    public void test8_1() {
        String data = "3 4 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Three of a Kind", outContent.toString());

    }
    
    @Test
    public void test8_1_2() {
        String data = "10 4 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("Three of a Kind", outContent.toString());

    }
    
    @Test
    public void test9() {
        String data = "3 3 5 4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Two Pairs", outContent.toString());

    }
    
    @Test
    public void test10() {
        String data = "13 3 13 1 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("One Pair", outContent.toString());

    }
    
    @Test
    public void test11() {
        String data = "13 3 10 1 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Nothing", outContent.toString());

    }

}
