/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author i.salnikov
 */
public class Collect {
    public static void main(String[] args) {
        List<Character> chars = Arrays.asList('h','e','l','l','o');
        
        String collect = chars.stream().collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append).toString();
        
        System.out.println(collect);
        
        
//          chars.stream().reduce(
//                StringBuilder::new,
//                StringBuilder::append,
//                StringBuilder::append).toString();
//        
//        System.out.println(redu);
        
    }
}
