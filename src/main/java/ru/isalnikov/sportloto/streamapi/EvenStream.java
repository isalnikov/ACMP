/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto.streamapi;

import java.util.PrimitiveIterator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenStream {

    public static void main(String[] args) {

        IntPredicate predicate = (int value) -> value%2 == 0;

        IntStream evenStream = IntStream.rangeClosed(1, 100).parallel().filter(predicate);
        PrimitiveIterator.OfInt itStream = IntStream.rangeClosed(1, 100).filter(predicate).iterator();
        //evenStream.forEach(System.out::println);
        
        
        System.out.println(itStream.next());
        System.out.println(itStream.next());
        System.out.println(itStream.next());
        System.out.println(itStream.next());
        System.out.println(itStream.next());

    }
}
