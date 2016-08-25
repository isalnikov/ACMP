package ru.isalnikov.acmp.acmp1111;

/**
 * Требуется определить число десятков в заданном натуральном числе в его
 * десятичной записи (то есть найти предпоследнюю цифру в числе).
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
            if (s.length() > 1) {
                out.print(s.charAt(s.length() - 2));
            } else {
                out.print("0");
            }
            out.flush();
        }
    }

}
