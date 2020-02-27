/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto;

import java.util.Random;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class Ganarator {

    public static void main(String[] args) {
        Random random = new Random();

        random.ints(2, 1, 3).forEach(System.out::println);
        System.out.println("");
        random.ints(2, 1, 2).forEach(System.out::println);
        System.out.println("");
        random.ints(2, 1, 2).forEach(System.out::println);
        System.out.println("");
        random.ints(2, 1, 2).forEach(System.out::println);
        System.out.println("");
        random.ints(2, 1, 2).forEach(System.out::println);
        System.out.println("");
        random.ints(2, 1, 2).forEach(System.out::println);
        System.out.println("");
        
        
        random.ints(5, 1, 90).forEach(System.out::println);
        System.out.println("");
        random.ints(5, 1, 90).forEach(System.out::println);
        System.out.println("");
        random.ints(5, 1, 90).forEach(System.out::println);
        System.out.println("");
        random.ints(5, 1, 90).forEach(System.out::println);
        System.out.println("");
    }
}
