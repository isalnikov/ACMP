package ru.isalnikov.acmp.acmp64;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.Test;
import static ru.isalnikov.acmp.acmp64.Main.primeNumbersTill;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

//    @Test
//    public void test() {
//        List<Integer> list = primeNumbersTill(10);
//        String st = primeNumbersTill(list);
//        assertEquals("2357", st);
//
//        // Количество цифр в простых числах от 2 до 20219 - 10004. 
//        list = primeNumbersTill(20219);
//        st = primeNumbersTill(list);
//        assertEquals(10004, st.length());
//    }

    @Test
    public void test1() {
        String data = "3\n"
                + "1 4 11";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("271", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "5\n"
                + "2 5 6 8 12";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("31139", outContent.toString());

    }

}
