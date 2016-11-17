package ru.isalnikov.yandex;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * http://java.svlugovoy.com/reverse-string/ 
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class PolindromeTest  {
    
    public PolindromeTest() {
    }
    
    @Test
    public void testMain() {
        assertFalse(Polindrome.isPolindrome(null));
        assertFalse(Polindrome.isPolindrome(""));
        assertFalse(Polindrome.isPolindrome("123"));
        assertFalse(Polindrome.isPolindrome("Козак"));
        assertTrue(Polindrome.isPolindrome("Казак"));
        assertTrue(Polindrome.isFastPolindrome("Казак"));
        assertTrue(Polindrome.isPolindrome("Sum summus mus"));
        assertTrue(Polindrome.isFastPolindrome("Sum summus mus"));
        assertTrue(Polindrome.isPolindrome("Saippuakivikauppias"));
        assertFalse(Polindrome.isPolindrome("Νίψον ανομήματα μη μόναν όψιν"));
        assertTrue(Polindrome.isFastPolindrome("Saippuakivikauppias"));
    }
    
}
