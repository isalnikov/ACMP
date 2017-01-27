package ru.isalnikov.acmp.acmp51;

/**
 * Факториалы!!!
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 26%) Определение 1:
 *
 * n!!...!=n(n-k)(n-2k)...(n mod k), если n не делится на k,
 *
 * n!!...!=n(n-k)(n-2k)...k, если n делится на k (знаков ! в обоих случаях k
 * штук).
 *
 * Определение 2:
 *
 * X mod Y — остаток от деления X на Y.
 *
 * Например, 10 mod 3 = 1; 3! = 3•2•1; 10!!! = 10•7•4•1;
 *
 * Мы по заданным n и k смогли вычислить значение выражения из определения 1. А
 * вам слабо?
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT содержится ровно одна строка. Сначала – целое
 * число n, (1 ≤ n ≤ 10) , затем ровно один пробел, затем k восклицательных
 * знаков (1 ≤ k ≤ 20).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите одно число – значение n!!..! .
 *
 *
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

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String[] a = in.nextLine().split(" ");
        int n = Integer.parseInt(a[0]);
        int k = a[1].length();

        int z = n % k;
        int i = n;
        int x = 1;
        if (z == 0) {
            while (i >= k) {
                x *= i;
                i = i - k;
            }
        } else {
            while (i >= z) {
                x *= i;
                i = i - k;
            }
        }
        out.print(x);
        out.flush();
    }

}
