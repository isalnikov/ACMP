package ru.isalnikov.acmp.acmp5;

/**
 * Вася не любит английский язык, но каждый раз старается получить хотя бы
 * четверку за четверть, чтобы оставаться ударником. В текущей четверти Вася
 * заметил следующую закономерность: по нечетным дням месяца он получал тройки,
 * а по четным – четверки. Так же он помнит, в какие дни он получал эти оценки.
 * Поэтому он выписал на бумажке все эти дни для того, чтобы оценить, сколько у
 * него троек и сколько четверок. Помогите Васе это сделать, расположив четные и
 * нечетные числа в разных строчках. Вася может рассчитывать на оценку 4, если
 * четверок не меньше, чем троек.
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
        int n = in.nextInt();
        int[] A = new int[100];
        int[] B = new int[100];
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int next = in.nextInt();
            if (next % 2 == 0) {
                A[a++] = next;
            } else {
                B[b++] = next;
            }
        }
        for (int i = 0; i < b; i++) {
            out.print(B[i] + " ");

        }
        out.println();
        for (int i = 0; i < a; i++) {
            out.print(A[i] + " ");

        }
        out.println();

        out.print((a >= b) ? "YES" : "NO");
    }

}
