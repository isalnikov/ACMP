package ru.isalnikov.acmp.acmp50;

/**
 * №50 Строки
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 34%) Циклическим сдвигом строки s
 * называется строка sksk+1sk+2…s|s|s1s2…sk-1 для некоторого k, здесь |s| -
 * длина строки s. Подстрокой строки s называется строка sisi+1…sj-1sj для
 * некоторых i и j. Вам даны две строки a и b. Выведите количество подстрок
 * строки a, являющихся циклическими сдвигами строки b.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит строку a (1 ≤ |a| ≤ 1000). Во
 * второй строке входного файла записана строка b (1 ≤ |b| ≤ min(100,|a|)). Обе
 * строки состоят только из символов латинского алфавита и цифр.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите целое число – ответ на задачу.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String a = in.nextLine();
        String b = in.nextLine();
        int ans = 0;
        HashSet<String> was = new HashSet<>();
        for (int i = 0; i < b.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < b.length(); j++) {
                sb.append(b.charAt((i + j) % b.length()));
            }
            if (!was.contains(sb.toString())) {
                was.add(sb.toString());
                ans += cntMatch(sb.toString(), a);
            }
        }

        out.print(ans);
        out.flush();
    }

    private static int cntMatch(String a, String b) {
        int n = a.length();
        StringBuilder s = new StringBuilder();
        s.append(" ");
        s.append(a);
        s.append("$");
        s.append(b);
        int[] p = new int[s.length()];
        p[0] = -1;
        p[1] = 0;
        int j = 0;
        for (int i = 2; i < s.length(); i++) {
            while (j >= 0 && s.charAt(j + 1) != s.charAt(i)) {
                j = p[j];
            }
            p[i] = ++j;
        }

        int res = 0;
        for (int i : p) {
            if (i >= a.length()) {
                res++;
            }
        }
        return res;
    }

}
