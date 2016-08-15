package ru.isalnikov.acmp.acmp204;

/**
 * Строка S была записана много раз подряд, после чего из получившейся строки
 * взяли подстроку и дали Вам. Ваша задача определить минимально возможную длину
 * исходной строки S.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записана строка, которая
 * содержит только латинские буквы, длина строки не превышает 50000 символов.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
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

    private static void prefixFunction(String s, int[] p) {
        int k = 0;
        for (int i = 1; i < s.length(); ++i) {
            while ((k > 0) && (s.charAt(k) != s.charAt(i))) {
                k = p[k - 1];
            }

            if (s.charAt(k) == s.charAt(i)) {
                ++k;
            }
            p[i] = k;
        }

    }

    private static void solve(Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int[] p = new int[s.length()];
        prefixFunction(s, p);

        out.print(s.length() - p[s.length()-1]);
        out.flush();
    }

}
