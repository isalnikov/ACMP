package ru.isalnikov.acmp.acmp58;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class MainTest extends BaseTest {

    @Test
    public void test1() {
//3
//1 1
//0
//4 4
//1 0 1 0
//1 1 1 0
//0 1 0 1
//0 0 0 0
//3 3
//0 0 1
//0 0 1
//1 1 1

        String data = "3\n"
                + "1 1\n"
                + "0\n"
                + "4 4\n"
                + "1 0 1 0\n"
                + "1 1 1 0\n"
                + "0 1 0 1\n"
                + "0 0 0 0\n"
                + "3 3\n"
                + "0 0 1\n"
                + "0 0 1\n"
                + "1 1 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES\n"
                + "YES\n"
                + "NO\n", outContent.toString());

    }
    
    
    @Test
    public void test2() {

        String data = "1\n"
                + "1 1\n"
                + "0\n";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES\n", outContent.toString());

    }
    
    
        @Test
    public void test3() {

        String data = "1\n"
                + "3 3\n"
                + "0 0 1\n"
                + "0 0 1\n"
                + "1 1 1";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO\n", outContent.toString());

    }
    
    

}
