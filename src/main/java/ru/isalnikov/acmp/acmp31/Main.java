package ru.isalnikov.acmp.acmp31;

/**
 * Перестановкой P[1..n] размера n называется набор чисел от 1 до n,
 * расположенных в определенном порядке. При этом в нем должно присутствовать
 * ровно один раз каждое из этих чисел. Примером перестановок являются 1,3,4,5,2
 * (для n=5) и 3,2,1 (для n=3), а, например, 1,2,3,4,5,1 перестановкой не
 * является, так как число 1 встречается два раза.
 *
 * Число i называется неподвижной точкой для перестановки P, если P[i] = i.
 * Например, в перестановке 1,3,4,2,5 ровно две неподвижных точки: 1 и 5, а
 * перестановка 4,3,2,1 не имеет неподвижных точек.
 *
 * Даны два числа: n и k. Найдите количество перестановок размера n с ровно k
 * неподвижными точками.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит два целых числа n (1 ≤ n ≤ 9) и k (0 ≤ k ≤
 * n).
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

    public static BigInteger factorial(int n) {
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

    public static BigInteger subfactorial(int x) {
        int i = x;
        int sign = 0;
        if (i % 2 == 1) {
            sign = -1;
        }
        if (i % 2 == 0) {
            sign = 1;
        }
        if (i == 0) {
            return BigInteger.ONE;
        }

        return subfactorial(i - 1).multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(sign));
    }

    private static void solve(Scanner in, PrintWriter out) {

        int n = in.nextInt();
        int k = in.nextInt();
        out.print(subfactorial(n - k).multiply(factorial(n).divide(factorial(n - k).multiply(factorial(k)))));
        out.flush();
    }
}
