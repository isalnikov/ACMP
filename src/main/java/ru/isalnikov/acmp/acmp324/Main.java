package ru.isalnikov.acmp.acmp324;

/**
 * Требуется написать программу, определяющую, является ли четырехзначное
 * натуральное число N палиндромом, т.е. числом, которое одинаково читается
 * слева направо и справа налево.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральное число N (1000 ≤ N ≤ 9999).
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {

        String s = in.nextLine();

        if (s.charAt(0) == s.charAt(3) && s.charAt(1) == s.charAt(2)) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        out.flush();
    }
}
