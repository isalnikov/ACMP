package ru.isalnikov.acmp.acmp92;

/**
 * Петя, Катя и Сережа делают из бумаги журавликов. Вместе они сделали S
 * журавликов. Сколько журавликов сделал каждый ребенок, если известно, что Петя
 * и Сережа сделали одинаковое количество журавликов, а Катя сделала в два раза
 * больше журавликов, чем Петя и Сережа вместе?
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано одно натуральное
 * число S – общее количество сделанных журавликов (S < 106).
 * <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            long s = in.nextLong();
            long x = s/6;
            out.print(x + " " + 4*x + " " + x);
            out.flush();
        }
    }

}
