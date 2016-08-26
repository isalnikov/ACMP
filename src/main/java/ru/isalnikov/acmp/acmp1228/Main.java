package ru.isalnikov.acmp.acmp1228;

/**
 * Простым числом называют натуральное число, у которого ровно два различных
 * натуральных делителя. Другими словами, число является простым, если оно
 * больше единицы и делится нацело только на себя и на единицу.
 *
 * Дано три целых числа. Требуется определить, какие из заданных чисел являются
 * простыми, и вычислить их сумму. Также требуется проверить, является ли
 * полученная сумма простыми числом.
 *
 * При решении данной задачи необходимо реализовать функцию IsPrime(N), которая
 * возвращает N, если N – простое число, и 0 – иначе.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит три целых числа, не превосходящие 1000 по
 * абсолютной величине.
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static boolean[] prime;

    public static boolean[] calcPrimes(int limit) {

        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));

        for (int x = 1; x < root; x++) {
            for (int y = 1; y < root; y++) {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    prime[n] = !prime[n];
                }
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7) {
                    prime[n] = !prime[n];
                }
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11)) {
                    prime[n] = !prime[n];
                }
            }
        }

        for (int i = 5; i <= root; i++) {
            if (prime[i]) {
                for (int j = i * i; j < limit; j += i * i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            
            int max = 3*Math.max(Math.max(a, b), c) +1;
            prime = new boolean[max];
            calcPrimes(max);
            
            int result = 0;
            if(prime[a]) result += a;
            if(prime[b]) result += b;
            if(prime[c]) result += c;
            
            out.println(result);
            if(prime[result]){
                out.print("Yes");
            }else{
                out.print("No");
            }
            out.flush();
        }
    }

}
