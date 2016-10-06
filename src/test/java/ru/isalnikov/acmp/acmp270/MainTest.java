/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp270;

import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "long_and_mnemonic_identifier";
        System.err.println(Main.toSnakeCase(data, true));
        System.err.println(Main.toSnakeCase(data, false));

    }
    
    
    @Test
    public void testMain() {
        String data = "long_and_mnemonic_identifier";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("longAndMnemonicIdentifier", outContent.toString());
    }

    @Test
    public void testMain1() {
        String data = "anotherExample";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("another_example", outContent.toString());
    }

    @Test
    public void testMain2() {
        String data = "i";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("i", outContent.toString());
    }

    @Test
    public void testMain3() {
        String data = "bad_Style";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Error!", outContent.toString());
    }
    @Test
    public void testMain27() {
        String data = "hello_world_";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Error!", outContent.toString());
    }
    
    @Test
    public void testMain24() {
        String data = "_";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Error!", outContent.toString());
    }
    @Test
    public void testMain15() {
        String data = "hello__world";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Error!", outContent.toString());
    }
    @Test
    public void testMain5() {
        String data = "ValueValue";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("Error!", outContent.toString());
    }

}
