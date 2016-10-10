package ru.isalnikov.acmp.acmp60;

/**
 * Простым числом будем называть натуральное число, большее единицы и делящееся
 * только на единицу и на само себя. Выпишем все простые числа в порядке
 * возрастания и i-ое в этом порядке число обозначим pi (число 2 при этом будет
 * иметь номер 1). Так, например, p1 = 2, p2 = 3, p3 = 5, p52 = 239.
 *
 * Скажем, что число pi является сверхпростым, если i = pk для некоторого k.
 * Иными словами, сверхпростое число — это простое число, номер которого в
 * списке простых чисел, упорядоченном по возрастанию, является простым числом.
 *
 * Дано натуральное число k. Упорядочим все сверхпростые числа по возрастанию.
 * Найдите k-ое сверхпростое число в этом порядке.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральное число k (1 ≤ k ≤ 500).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите k-ое сверхпростое число.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    private static boolean[] calcPrimes(int limit) {
        boolean[] prime = new boolean[limit < 3 ? 4 : limit + 1];
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

    public static int[] getPrimes(int N) {
        boolean[] primes = calcPrimes(N);
        int[] allPrimes = new int[10000];
        int j = 1;
        for (int i = 1; i < primes.length; i++) {
            if (primes[i]) {
                allPrimes[j++] = i;
            }
        }
        // System.err.println(Arrays.toString(allPrimes));
        
        int[] superPrimes = new int[600];
        j = 1;
        for (int i = 1; i < allPrimes.length; i++) {
            if(j > 500) break;
            if (primes[i]){
                superPrimes[j++] = allPrimes[i];
            }
            
        }
        return superPrimes;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] primes = getPrimes(40000);
        out.print(primes[n]);
        out.flush();

    }
}
