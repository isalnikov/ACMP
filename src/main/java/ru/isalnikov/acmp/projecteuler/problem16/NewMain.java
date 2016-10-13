
package ru.isalnikov.acmp.projecteuler.problem16;

import java.math.BigInteger;
import static java.util.function.Function.identity;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class NewMain {

  
    public static void main(String[] args) {
        
//         BigInteger
//                .valueOf(2016)
//                .pow(2)
//                .toString().chars().forEachOrdered(System.out::println);
        
       int s=  BigInteger
                .valueOf(2)
                .pow(1000)
                .toString()
                .chars()
                .mapToObj(Character::getNumericValue)
                .mapToInt(i->i).sum();
              
              System.out.println(s);  
    }
    
}
