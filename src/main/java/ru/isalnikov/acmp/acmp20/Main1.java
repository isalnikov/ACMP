package ru.isalnikov.acmp.acmp20;

/**
 * Последовательность a1, a2, a3, … , an-1, an называется пилообразной, если она
 * удовлетворяет одному из следующих условий: 1)	a1 < a2 > a3 < … > an-1 < an
 * 2)	a1 > a2 < a3 > … < an-1 > an
 *
 * Дана числовая последовательность. Требуется определить длину самой длинной ее
 * пилообразной непрерывной подпоследовательности.
 *
 * Входные данные
 *
 * В первой строке входного файла INPUT.TXT записано натуральное число N –
 * количество элементов последовательности. Во второй строке файла через пробел
 * записаны N элементов целочисленной последовательности {ai}. Ограничения:
 * N<10^6, |ai| < 32000.
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main1 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
         int n = Integer.parseInt(in.nextLine().trim());
         int[] array = IntStream.range(0, n).map(i -> in.nextInt()).toArray();

        int cur =  array[0];
        int prev = array[0];
        int prevPrev = array[0];
        int len = 1;
        int maxLen = 1;
        int j = 0;
        for (int i = 2; i <= n; i++) {
            prevPrev = prev;
            prev = array[0];
            cur = array[j++];
            if ((prev > cur && prev > prevPrev) || (prev < cur && prev < prevPrev)) {
                len++;
            } else if (prev != cur) {
                len = 2;
            } else {
                len = 1;
            }

            maxLen = Math.max(maxLen, len);
        }
        out.print(maxLen);
        out.flush();

    }
}
