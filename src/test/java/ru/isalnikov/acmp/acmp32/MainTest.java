/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp32;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import org.junit.Test;
import static org.junit.Assert.*;
import static ru.isalnikov.acmp.acmp32.Main.stringSwap;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "18\n"
                + "10";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("71", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "1\n"
                + "-23";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("33", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "-100\n"
                + "100";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-200", outContent.toString());

    }
    @Test
    public void test6() {
        String data = "0\n"
                + "100";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("-100", outContent.toString());

    }
    @Test
    public void test7() {
        String data = "-60102 -20021";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("12074", outContent.toString());

    }
    @Test
    public void test5() {
        String data = "10\n"
                + "0";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("10", outContent.toString());

    }

    @Test
    public void test3() {

        String ss = "18".chars()
                .map(Character::getNumericValue)
                
                .mapToObj(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .map(s-> s.toString())
                .collect(Collectors.joining());
        System.err.println(ss);
    }
    
    
        @Test
    public void test4() {

        String as = "00111";
           if (as.startsWith("0")) {
            for (int i = 0; i < as.length(); i++) {
                if (as.charAt(i) != '0') {
                    as = stringSwap(as, 0, i);
                    break;
                }

            }
        }
        
        System.err.println(as);
    }
    

}
