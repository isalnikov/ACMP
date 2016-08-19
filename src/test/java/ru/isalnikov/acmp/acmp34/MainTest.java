/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp34;

import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "10 5\n"
                + "0123456789";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "13 2\n"
                + "0123400056789";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

}
