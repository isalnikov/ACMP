/*
 * https://github.com/begoon/acm/tree/master/acmp.ru
 */
package ru.isalnikov.acmp.base;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class BaseTest {

    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public ByteArrayOutputStream inContent;

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
}
