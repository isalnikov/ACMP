package ru.isalnikov.acmp.acmp34;

/**
 * На секретную базу в Арктике поступила шифровка – последовательность из n
 * десятичных цифр. Она содержит номер секретной базы в Антарктиде, который
 * является последовательностью из k десятичных цифр. При этом для того, чтобы
 * отличить его от ненужной Вам информации, он повторен в шифровке хотя бы два
 * раза (возможно, эти два вхождения перекрываются).
 *
 * Напишите программу, которая по шифровке и длине номера секретной базы
 * определяет, содержит ли шифровка номер базы. Учтите, что у базы может быть
 * несколько номеров, и все они могут быть переданы в шифровке.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит два целых числа: n (1 ≤ n ≤
 * 105) и k (1 ≤ k ≤ 5) – длину шифровки и длину номера секретной базы
 * соответственно. Вторая строка содержит n цифр – шифровку. Помните, что цифры
 * в шифровке не разделяются пробелами.
 */
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static enum Result {
        YES, NO;
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int [] array =  new int[100_000];

        for (int i = 0; i < n - k; i++) {
            Integer key = Integer.parseInt(s.substring(i, k + i));

            array[key]++;

            if (array[key] > 1) {
                out.print(Result.YES);
                out.flush();
                return;
            }

        }

        out.print(Result.NO);
        out.flush();
    }

}
