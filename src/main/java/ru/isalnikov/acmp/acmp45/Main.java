package ru.isalnikov.acmp.acmp45;

/**
 * Требуется найти наименьшее натуральное число Q такое, что произведение его
 * цифр равно заданному числу N.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано одно целое число N (0
 * ≤ N ≤ 109).
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
        int n = in.nextInt();

        String res = "";

        if (n == 0) {
            res = "10";
            out.print(res);

            out.flush();
            return;
        }
        if (n < 10) {
            res = "" + n;
            out.print(res);

            out.flush();
            return;
        }

        int[] ar = new int[10];
        for (int i = 2; i <= 9; i++) {
            ar[i] = 0;
        }
        for (int i = 2; i <= 9; i++) {
            while (n % i == 0) {
                n /= i;
                ar[i]++;
            }
        }
        if (n != 1) {
            res = "-1";
        }
        while (ar[2] >= 3) {
            ar[2] -= 3;
            ar[8]++;
        }
        while (ar[3] >= 2) {
            ar[3] -= 2;
            ar[9]++;
        }
        while ((ar[2] > 0) && (ar[4] > 0)) {
            ar[2]--;
            ar[4]--;
            ar[8]++;
        }
        while ((ar[2] > 0) && (ar[3] > 0)) {
            ar[2]--;
            ar[3]--;
            ar[6]++;
        }
        while (ar[2] >= 2) {
            ar[2] -= 2;
            ar[4]++;
        }
        while ((ar[2] > 0) && (ar[4] > 0)) {
            ar[2]--;
            ar[4]--;
            ar[8]++;
        }
        for (int i = 2; i <= 9; i++) {
            while (ar[i] > 0) {
                ar[i]--;
                res += i;
            }
        }
        if (res.equals("")) {
            res = "-1";

        }

        out.print(res);

        out.flush();
    }

}
