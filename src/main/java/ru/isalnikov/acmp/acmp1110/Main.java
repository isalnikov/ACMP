package ru.isalnikov.acmp.acmp1110;

/**
 * Требуется определить последнюю цифру натурального числа.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральное число, не превосходящее 109.
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
            out.print(s.charAt(s.length()-1));
            out.flush();
        }
    }

}
