package ru.isalnikov.acmp.acmp70;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Igor Salnikov
 *
 * Пусть задана строка s = s1s2...sn. Назовем ее k-ой (k > 0) степенью sk строку
 * sk = s1s2 . . .sns1s2 . . .sn......s1s2...sn (k раз). Например, третьей
 * степенью строки abc является строка abcabcabc.
 *
 * Корнем k степени из строки s называется такая строка t (если она существует),
 * что tk = s.
 *
 * Ваша задача состоит в том, чтобы написать программу, находящую степень строки
 * или корень из нее.
 *
 * Входные данные Первая строка входного файла INPUT.TXT содержит строку s, она
 * содержит только маленькие буквы английского алфавита и имеет ненулевую длину,
 * не превосходящую 1000.
 *
 * Вторая строка входного файла содержит целое число k ≠ 0, |k| < 100001. Если k
 * > 0, то необходимо найти k-ую степень строки s, если k < 0, то необходимо
 * найти корень степени |k| из s.
 *
 * Выходные данные В выходной файл OUTPUT.TXT выведите строку, являющуюся
 * ответом на задачу. Если длина ответа превосходит 1023 символа, выведите
 * только первые 1023 символа. Если искомой строки не существует — выведите NO
 * SOLUTION.
 *
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String s = (in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        try {
            if (n > 0) {
                if (s.length() * n > 1023) {

                    StringBuilder sb = new StringBuilder(s);
                    sb.append(s);
                    while (sb.length() < 1024) {
                        sb.append(s);
                    }
                    out.print(sb.substring(0, 1023));

                } else {
                    out.print(String.join("", Collections.nCopies(n, s)));
                }
            } else if (n < 0) {
                int k = s.length() / Math.abs(n);

                String[] ar = s.split("(?<=\\G.{" + k + "})");
                HashSet<String> set = new HashSet<>(Arrays.asList(ar));
                if (set.size() == 1) {
                    out.print(set.iterator().next());
                } else {
                    out.print("NO SOLUTION");
                }
            }
        } catch (Exception e) {
            out.print("NO SOLUTION");
        }
        out.flush();
    }
}
