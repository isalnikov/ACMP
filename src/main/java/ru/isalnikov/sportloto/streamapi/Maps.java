/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto.streamapi;

import static java.util.Arrays.asList;
import java.util.List;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author i.salnikov
 */
public class Maps {

    public static void main(String[] args) {

        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)) // Stream of List<Integer>
                .flatMap(List::stream)
                .map(identity())
                .collect(Collectors.toList());
        System.out.println(together);
    }
}
