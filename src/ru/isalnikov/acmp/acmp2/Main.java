package ru.isalnikov.acmp.acmp2;

/**
 * Требуется посчитать сумму целых чисел от 1 до N.
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
        if (n > 0) {
            out.println((n * (n + 1)) / 2);
        } else {
            out.println((Math.abs(n) * (-1 + n)) / 2 +1);
        }
    }
}
