package ru.isalnikov.acmp.acmp224;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
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
    @Test
    public void test3_1() {
        String data = "3\n"
                + "-5 -30000 -12";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("-1800000", outContent.toString());

    }
    
        @Test
    public void test1_1() {
        String data = "9\n"
                + "3 5 1 7 9 0 9 -3 10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("810", outContent.toString());

    }
        @Test
    public void test1_2() {
     
                int[] data = new int[]{3, 5, 1, 7, 9, 0, 9, -3, 10};
        
            LimitedQueue maxLimitedQueue = new LimitedQueue(3, Comparator.<Integer>naturalOrder());
            LimitedQueue minLimitedQueue = new LimitedQueue(2,Comparator.<Integer>reverseOrder());
            for (int i = 0; i < data.length; i++) {
               maxLimitedQueue.add(data[i]);
               minLimitedQueue.add(data[i]);
                
            }
            
            System.err.println(maxLimitedQueue);
            System.err.println(minLimitedQueue);
        
    }

}
