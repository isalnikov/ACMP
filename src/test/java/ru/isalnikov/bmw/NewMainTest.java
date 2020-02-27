package ru.isalnikov.bmw;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class NewMainTest {
    
    public NewMainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  
    @Test
    public void testTwoStringsYes() {
        
        String s1 = "hello";
        String s2 = "world";
        String expResult = "YES";
        String result = NewMain.twoStrings(s1, s2);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testTwoStringsNo() {
        
        String s1 = "hi";
        String s2 = "world";
        String expResult = "NO";
        String result = NewMain.twoStrings(s1, s2);
        assertEquals(expResult, result);
       
    }
    
}
