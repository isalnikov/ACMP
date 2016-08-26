package ru.isalnikov.acmp.acmp1226;

/**
 * Дано три символа. Требуется определить, сколько из них являются буквами
 * латинского алфавита (в любом регистре).
 *
 * При решении данной задачи необходимо реализовать функцию IsLetter(C), которая
 * возвращает 1, если символ C – латинская буква, и 0 – иначе.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит три символа, разделенные пробелом.
 * Гарантируется, что ASCII-коды символов превышают 32.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            String[] s = in.nextLine().split(" ");

            int count = 0;
            for (String s1 : s) {
                if (Character.isAlphabetic(s1.charAt(0))) {
                    count++;
                }
            }

            out.print(count);

            out.flush();
        }
    }

}
