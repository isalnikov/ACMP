package ru.isalnikov.acmp.acmp46;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("3", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "25";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2.7182818284590452353602875", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "13";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2.7182818284590", outContent.toString());

    }
    @Test
    public void test5_1() {
        String data = "10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2.7182818285", outContent.toString());

    }
    @Test
    public void test1_1() {
        String data = "0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("3", outContent.toString());

    }

    @Test
    public void test2_1() {
        String data = "25";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("2.7182818284590452353602875", outContent.toString());

    }

    @Test
    public void test4_1() {
        String data = "13";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("2.7182818284590", outContent.toString());

    }
    
    @Test
    public void test7_1() {
        String data = "2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("2.72", outContent.toString());

    }

    @Test
    public void test6_1() {
        String res = "7182818284590452353602875";

        char[] chars = res.toCharArray();

        System.err.println(chars);
        
        System.err.println(""+ (chars[0]-48+1));
        System.err.println(""+ (chars[1]-48+1));
        System.err.println(""+ (chars[2]-48+1));
        System.err.println(""+ (chars[3]-48+1));

    }
    @Test
    public void test5() {
        String data = "2.7182818284590452353602875";

        System.err.println(data.length());
        
         DecimalFormat df = new DecimalFormat("0.0000000000000");
         System.err.println(df.format(2.7182818284590452353602875));
       

    }
    @Test
    public void test6() {

        BigDecimal decimal = BigDecimal.valueOf(2.7182818284590452353602875);

        System.err.println(decimal.toString());
        System.err.println(Math.E);
        System.err.println();
        System.err.println(decimal.setScale(0, BigDecimal.ROUND_HALF_UP));
        System.err.println(decimal.setScale(1, BigDecimal.ROUND_HALF_UP));
        System.err.println(decimal.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.err.println(decimal.setScale(3, BigDecimal.ROUND_HALF_UP));
        System.err.println(decimal.setScale(13, BigDecimal.ROUND_HALF_UP));
        System.err.println(decimal.setScale(25, BigDecimal.ROUND_HALF_UP));

    }
   

}
