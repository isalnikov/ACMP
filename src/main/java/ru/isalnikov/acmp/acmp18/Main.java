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
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static BigInteger streamedParallel(int n) {
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

    private static void solve(Scanner in, PrintWriter out) {
        final int N = in.nextInt();
        out.print(streamedParallel(N));
        out.flush();
    }

}
