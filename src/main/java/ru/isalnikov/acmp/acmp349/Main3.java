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

class Main3 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int m = in.nextInt();
            int n = in.nextInt();

            BigInteger bi = BigInteger.valueOf(m);
            int[] array = new int[(n - m + 1)];
            int count = 0;
            if (bi.isProbablePrime(5)) {
                array[0] = bi.intValue();
                count++;
            }
            while (m < n) {
                bi = bi.nextProbablePrime();
                array[count++] = m = bi.intValue();

            }
            
            if(count >1 &&  array[count-1] > n) count =  count -1;
            
            
            

            if (count == 0) {
                out.println("Absent");
            } else {
                array = Arrays.copyOfRange(array, 0, count);
                for (int b : array) {
                    out.println(b);
                }
            }
            out.flush();
        }
    }
}
