/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp12;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;


public class MainTest extends BaseTest{
    
   
     @Test
    public void test1() {
         String data = "3\n"
                 + "6 6 3 6 6 9 8 7 5 4\n"
                 + "13 5 9 2 9 8 12 8 12 2\n"
                 + "3 2 2 1 2 3 6 3 6 1";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("2", outContent.toString());

    }
    
}
