/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto.streamapi;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class StringHashcode {

    public static void main(String[] args) {

        System.out.println("Stoloto".chars().reduce(0, (a, b) -> a * 31 + b));

    }
}
