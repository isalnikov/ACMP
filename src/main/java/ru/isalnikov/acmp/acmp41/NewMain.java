/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp41;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class NewMain {

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"));
                PrintWriter out = new PrintWriter(new File("output.txt"))) {

            int a = in.nextInt();
            int b = in.nextInt();

            out.println((b - 1) + " " + (a - 1));
            out.flush();
        }
    }
    
}
