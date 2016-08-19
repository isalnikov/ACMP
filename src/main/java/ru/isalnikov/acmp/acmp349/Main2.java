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
 *
 *
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main2 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int m = in.nextInt();
            int n = in.nextInt();
            BigInteger bi = BigInteger.valueOf(m);
            int count = 0;
            
            if (bi.isProbablePrime(5)) {
                out.println(bi.intValue());
                count++;
            }
            if ((m & 1) == 0) {
                m++;
            }

            while (m <= n) {

                bi = BigInteger.valueOf(m);
                if (bi.isProbablePrime(5)) {
                    out.println(bi.intValue());
                    count++;
                }
                m = m + 2;
            }

            if (count == 0) {
                out.println("Absent");
            }
            out.flush();
        }
    }
}
