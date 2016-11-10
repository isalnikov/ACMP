package ru.isalnikov.acmp.acmp149;

/**
 * Дано натуральное число N и последовательность из N элементов. Требуется
 * вывести эту последовательность в обратном порядке.
 *
 * Входные данные
 *
 * В первой строке входного файла INPUT.TXT записано натуральное число N (N ≤
 * 103). Во второй строке через пробел идут N целых чисел, по модулю не
 * превосходящих 103 - элементы последовательности.
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
        int array[] = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                out.print(" ");
            }
            out.print(array[N - i - 1]);
        }
        out.flush();
    }

}
