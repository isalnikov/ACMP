/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp11;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class MainTest extends BaseTest {

    public MainTest() {
    }

    @Test
    public void test1() {
        String data = "1 3";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "2 7";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("21", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "3 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("274", outContent.toString());

    }
    @Test
    public void test4() {
        String data = "300 300";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1018517988167243043134222844204689080525734196832968125318070224677190649881668353091698688", outContent.toString());

    }

}
