/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp178;

import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final Integer N = in.nextInt();
        System.out.println("");
           final List<Integer> laneWidths
            = IntStream.range(0, N).map(i -> in.nextInt()).boxed().collect(toList());
                System.out.println("");
                laneWidths.forEach(System.out::println);
    }
}
