/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto.streamapi;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * конкатенация всех комбинаций
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class SupplierStreram {

    public static void main(String[] args) {

        List<List<String>> input = asList(
                asList("a", "b"),
                asList("x", "y"),
                asList("1", "2"));

        Stream<String> stream
                = input.get(0).stream()
                .peek(System.out::println)
                .flatMap(a
                        -> input.get(1)
                        .stream()
                        .peek(System.out::println)
                        .flatMap(b
                                -> input.get(2)
                                .stream()
                                .peek(System.out::println)
                                .map(c -> a + b + c)));
//        
        //stream.forEach(System.out::println);
        System.out.println("!!!!!!!!!!");
        //System.exit(0);
        Supplier<Stream<String>> s
                = input.stream()
                .peek(System.out::println)
                .<Supplier<Stream<String>>>map(list -> list::stream)
                .peek(System.out::println)
                .reduce((sup1, sup2) -> () -> sup1.get()
                        .peek(System.out::println)
                        .flatMap(e1 -> sup2.get().map(e2 -> e1 + e2)))
                .orElse(() -> Stream.of(""));

        s.get().forEach(System.out::println);
        
        //s.get().forEach(System.out::println);

    }
}
