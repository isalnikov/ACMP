package ru.isalnikov.yandex;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class MedianProblemTest {

    @Test
    public void testMed_3args() {
        assertEquals("ака", ManachersAlgorithm.findLongestPalindrome("абракадабра"));
        assertEquals("анана", ManachersAlgorithm.findLongestPalindrome("банана"));
    }

}
