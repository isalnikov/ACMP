package ru.isalnikov.acmp.acmp1112;

/**
 * Найдите сумму цифр трехзначного натурального числа.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит трехзначное натуральное число.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            String s = in.nextLine();
            out.print(Integer.parseInt(""+s.charAt(0)) + Integer.parseInt(""+s.charAt(1)) + Integer.parseInt(""+s.charAt(2)));
            out.flush();
        }
    }

}
