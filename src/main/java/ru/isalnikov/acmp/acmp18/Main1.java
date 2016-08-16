package ru.isalnikov.acmp.acmp18;

/**
 * Требуется вычислить факториал целого числа N. Факториал обозначают как N! и
 * вычисляют по формуле:
 *
 * N! = 1 * 2 * 3 * … * (N-1) * N, причем 0! = 1.
 *
 * Так же допустимо рекуррентное соотношение: N! = (N-1)! * N
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static BigInteger ProdTree(int left, int right) {
        if (left > right) {
            return BigInteger.ONE;
        }
        if (left == right) {
            return BigInteger.valueOf(left);
        }
        if (right - left == 1) {
            return BigInteger.valueOf(left).multiply(BigInteger.valueOf(right));
        }
        int m = (left + right) / 2;
        return ProdTree(left, m).multiply(ProdTree(m + 1, right));
    }

    public static BigInteger TreeFactorial(int n) {
        if (n < 0) {
            return BigInteger.ZERO;
        }
        if (n == 0) {
            return BigInteger.ONE;
        }
        if (n == 1 || n == 2) {
            return BigInteger.valueOf(n);
        }
        return ProdTree(2, n);
    }

    private static void solve(Scanner in, PrintWriter out) {
        final int N = in.nextInt();
        out.print(TreeFactorial(N));
        out.flush();
    }

}
