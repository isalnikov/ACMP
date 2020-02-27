package ru.isalnikov.sportloto.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * https://howtodoinjava.com/java-8/java-8-tutorial-streams-by-examples/
 * 
 * @author Igor Salnikov isalnikov.com
 */
public class SomeList {
    public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
         Stream<Integer> stream = list.stream();
         stream.forEach(p -> System.out.println(p));
    }
}
