/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp178;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.IntStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest1 {

    
    
    @Test
    public void test() {
      
        Comparator<? super Map.Entry<Integer, Long>> maxValueComparator = (
                entry1, entry2) -> entry1.getValue().compareTo(
                        entry2.getValue());
        
       IntStream intStream = IntStream.of(1, 2, 3, 2, 3, 1, 2,1);
       
          Optional<Map.Entry<Integer, Long>>  maxValue  =
                intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()) 
               
                .limit(10) 
                .peek(System.out::println)
                 .findFirst();
                //.min(maxValueComparator.reversed());
      
         assertEquals((long)1L ,(long) maxValue.get().getKey());
    }

   

}
