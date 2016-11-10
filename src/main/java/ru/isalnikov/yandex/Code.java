/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex;

import java.util.stream.Stream;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class Code {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int x = 3, y = 5, z = 2;

        if (x <= y) {
            x += z;
            if (z != x) {
                y = (x - z) / y;
            }
            z++;
        } else if (y == 0) {
            y++;
            z *= y;
        }
 
        System.out.println(String.format("%d %d %d ", x,y,z));
        //5 0 3 
    }

}
