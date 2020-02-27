/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp349;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int m = 2;  
       int n = 100;  
       BigInteger bi = BigInteger.valueOf(m);
        int[] array = new int[(n-m)];
        int count = 0;
        if(bi.isProbablePrime(5)){
            array[0] = bi.intValue();
            count++;
        }
        while (m < n) {            
              bi = bi.nextProbablePrime();
              array[count++] = m = bi.intValue();
              
        }
         array = Arrays.copyOfRange(array, 0, count);
       
         System.out.println(Arrays.toString(array));
    }
    
}
