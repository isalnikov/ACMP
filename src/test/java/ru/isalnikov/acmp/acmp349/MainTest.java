/*
 *https://habrahabr.ru/post/133037/
 */
package ru.isalnikov.acmp.acmp349;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

//https://habrahabr.ru/post/122538/
// Листинг 7
//n = input("n=")
//lst=[2]
//for i in xrange(3, n+1, 2):
//	if (i > 10) and (i%10==5):
//		continue
//	for j in lst:
//		if j*j-1 > i:
//			lst.append(i)
//			break
//		if (i % j == 0):
//			break
//	else:
//		lst.append(i)
//print lst

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "2 5";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2\n"
                + "3\n"
                + "5\n", outContent.toString());

    }
    
        @Test
    public void test4_1_1() {
        String data = "2 5";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main4.main(null);

        assertEquals("2\n"
                + "3\n"
                + "5\n", outContent.toString());

    }

    @Test
    public void test_2() {
        String data = "2 5";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals("2\n"
                + "3\n"
                + "5\n", outContent.toString());

    }

    @Test
    public void test_3() {
        String data = "2 97";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals("2\n"
                + "3\n"
                + "5\n"
                + "7\n"
                + "11\n"
                + "13\n"
                + "17\n"
                + "19\n"
                + "23\n"
                + "29\n"
                + "31\n"
                + "37\n"
                + "41\n"
                + "43\n"
                + "47\n"
                + "53\n"
                + "59\n"
                + "61\n"
                + "67\n"
                + "71\n"
                + "73\n"
                + "79\n"
                + "83\n"
                + "89\n"
                + "97\n", outContent.toString());

    }

    @Test
    public void test_3_1() {
        String data = "4 30";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals(
                 "5\n"
                + "7\n"
                + "11\n"
                + "13\n"
                + "17\n"
                + "19\n"
                + "23\n"
                + "29\n", outContent.toString());

    }
    @Test
    public void test_3_2() {
        String data = "4 31";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals(
                "5\n"
                + "7\n"
                + "11\n"
                + "13\n"
                + "17\n"
                + "19\n"
                + "23\n"
                + "29\n"
                + "31\n", outContent.toString());

    }
    @Test
    public void test_3_3() {
        String data = "2 31";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals(
                "2\n"
                + "3\n"
                + "5\n"
                + "7\n"
                + "11\n"
                + "13\n"
                + "17\n"
                + "19\n"
                + "23\n"
                + "29\n"
                + "31\n", outContent.toString());

    }
    @Test
    public void test_3_4() {
        String data = "2 32";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals(
                "2\n"
                + "3\n"
                + "5\n"
                + "7\n"
                + "11\n"
                + "13\n"
                + "17\n"
                + "19\n"
                + "23\n"
                + "29\n"
                + "31\n", outContent.toString());

    }

    @Test
    @Ignore
    public void test_1() {
        String data = "2 5";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("2\n"
                + "3\n"
                + "5\n", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Absent\n", outContent.toString());

    }
    @Test
    public void test4_1() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main4.main(null);

        assertEquals("Absent\n", outContent.toString());

    }
    @Test
    public void test3_1() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals("Absent\n", outContent.toString());

    }
    @Test
    public void test3_2() {
        String data = "2 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main2.main(null);

        assertEquals("2\n", outContent.toString());

    }

    @Test
    @Ignore
    public void test1_1() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(new String[]{"4 4"});

        assertEquals("Absent\n", outContent.toString());

    }

    @Test
    public void test1_2() {
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            Main1.main(new String[]{"2", "1000000"});
            System.err.println("time : " + (System.currentTimeMillis() - start) + " ms");
        }

    }

    @Test
    public void test2() {
        String data = "2 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("2\n", outContent.toString());

    }
    @Test
    public void test4_2() {
        String data = "2 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main4.main(null);

        assertEquals("2\n", outContent.toString());

    }
    @Test
    public void test3_1_2() {
        String data = "2 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main3.main(null);

        assertEquals("2\n", outContent.toString());

    }
    @Test
    public void test3_1_3() {
        String data = "4 4";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main3.main(null);

        assertEquals("Absent\n", outContent.toString());

    }
    
    
        @Test
    public void test_3_4_1() {
        String data = "2 32";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main3.main(null);

        assertEquals(
                "2\n"
                + "3\n"
                + "5\n"
                + "7\n"
                + "11\n"
                + "13\n"
                + "17\n"
                + "19\n"
                + "23\n"
                + "29\n"
                + "31\n", outContent.toString());

    }

    @Test
    public void test3() {
        int m = 19;
        int n = 101;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

    @Test
    public void test4() {
        int m = 4;
        int n = 4;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

    @Test
    public void test5() {
        int m = 2;
        int n = 5;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

    @Test
    public void test6() {
        int m = 999979;
        int n = 1_000_000;
        BigInteger bi = new BigInteger(String.valueOf(m));
        if (bi.isProbablePrime(m)) {
            System.err.println(bi.intValue());
        }
        while (bi.compareTo(BigInteger.valueOf(n)) < 0) {

            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                System.err.println(bi.intValue());

            }

        }

    }

}
