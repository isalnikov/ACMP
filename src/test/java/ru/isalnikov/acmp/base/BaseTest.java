
package ru.isalnikov.acmp.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class BaseTest {

    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public ByteArrayInputStream inContent;

    private static InputStream stdin;
    private static PrintStream stdout;

    @BeforeClass
    public static void setUpClass() {
        stdin = System.in;
        stdout = System.out;
    }

    @AfterClass
    public static void tearDownClass() {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        inContent = null;
    }
 
    public static ByteArrayInputStream input(String input) {
        return new ByteArrayInputStream(input.getBytes());

    } 
}
