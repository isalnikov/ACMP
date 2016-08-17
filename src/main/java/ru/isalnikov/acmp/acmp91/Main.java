package ru.isalnikov.acmp.acmp91;

/**
 * Определим последовательности an и bn следующим образом: a1 = 2, a2 = 3, a3 =
 * 4, a4 = 7, an = bn−1 + bn−3, n > 4, bn — последовательность чисел, не
 * входящих в an, записанных в возрастающем порядке.
 *
 * Таким образом, последовательность an будет выглядеть следующим образом: 2, 3,
 * 4, 7, 13, 15,..., а последовательность bn – 1, 5, 6, 8, 9, 10,....
 *
 * Ваша задача состоит в том, чтобы найти an и bn.
 *
 * Входные данные
 *
 * Входной файл содержит целое число n (1 ≤ n ≤ 10000).
 *
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

    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();

        int a[];
        int b[];
        int Size = 7;
        if (N >= Size) {
            Size = N + 3;
        }

        a = new int[Size];
        b = new int[Size];

        a[0] = 0;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 7;
        a[5] = 13;
        a[6] = 15;
        //
        b[0] = 0;
        b[1] = 1;
        b[2] = 5;
        b[3] = 6;
        b[4] = 8;
        b[5] = 9;
        b[6] = 10;

        if (a[N] > 0 && b[N] > 0) {
            out.println(a[N]);
            out.print(b[N]);
            out.flush();
            return;
        }

        int aindex = 5;
        for (int i = 6; i <= N + 1; i++) {
            if (b[i - 1] == 0) {
                //TODO пробежаться по всем a[j] и b[k]  и найти свободные члены  - заполнить  b[k] ... b[k+1] ...
                b[i - 1] = b[i - 2] + 1;
                if (b[i - 1] == a[aindex]) {
                    b[i - 1]++;
                    aindex++;
                }

            }
            a[i] = b[i - 1] + b[i - 3];
        }

        out.println(a[N]);
        out.print(b[N]);
        out.flush();
    }

}
