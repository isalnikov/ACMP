package ru.isalnikov.acmp.acmp1227;

/**
 * Факториал числа n – произведение всех натуральных чисел от 1 до n:
 *
 *
 * Сочетанием из n по k называют набор из k элементов, выбранных из данного
 * множества, содержащего n различных элементов. При этом наборы, отличающиеся
 * только порядком следования элементов, считаются одинаковыми.
 *
 * Число возможных сочетаний из n по k вычисляется по следующей формуле:
 *
 *
 * По заданным целым числам n и k требуется вычислить число сочетаний.
 *
 * При решении данной задачи необходимо реализовать функцию F(n), вычисляющую
 * факториал числа.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит целые числа n и k (0 ≤ k ≤ n ≤ 20).
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    static long[] cache = new long[21];

    public static long factorial(int n) {
        if (n == 0) {
            cache[0] = 1;
            return 1;
        }

        if(cache[n]>0) return cache[n];
        
        long ret = 1;
        for (int i = 1; i <= n; ++i) {
            ret *= i;
            cache[i] = ret;
            
        }
        return ret;
    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            int k = in.nextInt();
            out.print(factorial(n)/(factorial(k)*factorial(n-k)));
            out.flush();
        }
    }

}
