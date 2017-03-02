
package ru.isalnikov.acmp.acmp54;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 *
 */
public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test() {
        String data = "3 3\n"
                + "4 -1 -3\n"
                + "-2 1 3\n"
                + "0 2 -3";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-2 2", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "3 4\n"
                + "-1 0 2 1\n"
                + "-2 0 1 0\n"
                + "2 1 -1 -2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-1 1", outContent.toString());

    }
    
    @Test
    public void test3() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        IntStream stream = Arrays.stream(arr).flatMapToInt(x -> Arrays.stream(x));
        //stream.forEachOrdered(System.err::println);

        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.err.println(sum);

        System.err.println(IntStream.range(0, Integer.MAX_VALUE).sum());
        System.err.println(IntStream.rangeClosed(0, Integer.MAX_VALUE).sum());
        System.err.println(LongStream.range(0, Integer.MAX_VALUE).sum());
        System.err.println(LongStream.rangeClosed(0, Integer.MAX_VALUE).sum());
        
        int s = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            s += i;
        }
        System.err.println(s);
    }
    

}
