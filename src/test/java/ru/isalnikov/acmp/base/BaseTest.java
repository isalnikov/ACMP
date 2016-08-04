/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.base;

import java.io.ByteArrayInputStream;
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
