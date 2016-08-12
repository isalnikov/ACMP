
package ru.isalnikov.acmp.acmp178;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class Main1Test extends BaseTest{
    
   
    @Test
    public void testMain() {
         String data = "7\n"
                + "1 2 3 2 3 1 2";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main1.main(null);

        assertEquals("1 3 3 1 2 2 2", outContent.toString());

    }
    
}
