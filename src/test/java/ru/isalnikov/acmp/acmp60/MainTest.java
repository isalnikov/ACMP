
package ru.isalnikov.acmp.acmp60;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;


//  Не верно: 1->2, 2->3, 3->5, 4->7, 5->11. 
//Поэтому ряд сверхпростых чисел начинается так: 3, 5, 11. Число 11 стоит на 5м, а не на 4м месте.

public class MainTest extends BaseTest{
    
    
    @Test
    public void testIsPP(){
        
        int[] pr = Main.getPrimes(50000);  
        System.err.println(Arrays.toString(pr));
        System.err.println(pr[1]);
        System.err.println(pr[2]);
        System.err.println(pr[3]);
        System.err.println(pr[5]);
        System.err.println(pr[52]);
        System.err.println(pr[500]);
    }
    
    @Test
    public void test() {
        String data = "1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("3", outContent.toString());

    }
    @Test
    public void test1() {
        String data = "2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("5", outContent.toString());

    }
    
    @Test
    public void test2() {
        String data = "3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("11", outContent.toString());

    }
    
    @Test
    public void test3() {
        String data = "100";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("3911", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "500";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("33347", outContent.toString());

    }
    
}
