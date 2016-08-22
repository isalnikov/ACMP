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
import java.util.*;

class Main4 {

    public static boolean[] calcPrimes(int limit) {

        boolean[] prime = new boolean[limit <3 ? 4: limit + 1];
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
    public static void display(int min, int max ,  PrintWriter out) {
        boolean[] array = Arrays.copyOfRange(calcPrimes(max), min, max + 1);
        boolean isExist = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                isExist = true;
                out.println((i + min));
            }
        }
        
        if(!isExist){
             out.println("Absent");
        }
        out.flush();
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int m = in.nextInt();
            int n = in.nextInt();
            
            display(m , n , out) ;
     
        }
    }
}
