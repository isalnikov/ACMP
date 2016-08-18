package ru.isalnikov.acmp.acmp31;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "5 2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("20", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "9 6";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("168", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "2 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("0", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "9 0";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("133496", outContent.toString());

    }

    @Test
    public void test6() {
        String data = "8 8";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    static void nextPermutation(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            nextPermutation(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            System.err.println(java.util.Arrays.toString(arr.toArray()));
        }
    }

    @Test
    public void test7() {
        nextPermutation(Arrays.asList(3, 4, 6, 2, 1), 0);

    }
    
    @Test
    public void test5() {
        nextPermutation(Arrays.asList(1,2, 3, 4,5), 0);

    }

}
