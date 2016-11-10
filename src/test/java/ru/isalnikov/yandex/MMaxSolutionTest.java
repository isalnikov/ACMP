/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex;

import org.junit.Assert;
import org.junit.Test;
import static ru.isalnikov.yandex.MMaxSolution.solution2;
import static ru.isalnikov.yandex.MMaxSolution.solution3;
import static ru.isalnikov.yandex.MMaxSolution.solution4;


public class MMaxSolutionTest {
    
   
    @Test
    public void testSomeMethod1() {
        Assert.assertArrayEquals(new int[]{3, 2}, solution2(new int[]{1, 2, 3}));
    }
    
    @Test
    public void testSomeMethod2() {
         int[] a = {1, 4, 67, 8, 2, 1 - 4, 4, 57, 3, -44, 46};
        Assert.assertArrayEquals(new int[]{57,67}, solution3(a,2));
    }
    
    @Test
    public void testSomeMethod3() {
         int[] a = {1, 4, 67, 8, 2, 1 - 4, 4, 57, 3, -44, 46};
        Assert.assertArrayEquals(new int[]{57,67}, solution4(a,2));
    }
    
}
