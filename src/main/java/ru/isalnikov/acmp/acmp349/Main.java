package ru.isalnikov.acmp.acmp349;

/**
 * Необходимо вывести все простые числа от M до N включительно.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит два натуральных числа M и N, разделенных
 * пробелом (2 ≤ M ≤ N ≤ 10^6)
 *
 *
 * https://habrahabr.ru/post/133037/
 * http://stackoverflow.com/questions/10580159/sieve-of-atkin-explanation-and-java-example
 * https://gist.github.com/hephaestus9/6a47e429f3f8c91d87bd
 *
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int m = in.nextInt();
            int n = in.nextInt();
            BigInteger bi = new BigInteger(String.valueOf(m));
            int count = 0;
            if (bi.isProbablePrime(m)) {
                out.println(bi.intValue());
                count++;
            }
            while (bi.compareTo(BigInteger.valueOf(n)) < 0) {
                bi = bi.nextProbablePrime();
                if (bi.compareTo(BigInteger.valueOf(n)) <= 0) {
                    out.println(bi.intValue());
                    count++;
                }
            }
            if (count == 0) {
                out.println("Absent");
            }
            out.flush();
        }
    }
}
