
package ru.isalnikov.projecteuler.problem16;

import java.math.BigInteger;


public class NewMain {


    public static void main(String[] args) {
        
int s =  BigInteger
                .valueOf(2)
                .pow(1000)
                .toString()
                .chars()
                .mapToObj(Character::getNumericValue)
                .mapToInt(i->i).sum();
              
              System.out.println(s); 
    }
    
}
