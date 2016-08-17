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

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = Integer.parseInt(in.nextLine().trim());
        int[] array = IntStream.range(0, N).map(i -> in.nextInt()).toArray();

        int maxLen = -1;

        int last = 0;
        int sign = 0;
        int r = 0;
        for (int i = 0; i < N; ++i) {
            int v = array[i];
            if (i == 0) {
                r += 1;
            } else if (i == 1) {
                sign = last < v ? -1 : 1;
                r += 1;
            } else {
                if (sign == -1 && last > v) {
                    sign = 1;
                    r += 1;
                } else if (sign == 1 && last < v) {
                    sign = -1;
                    r += 1;
                } else {
                    if (r > maxLen) {
                        maxLen = r;
                    }
                    r = 2;
                    sign = last < v ? -1 : 1;
                }
            }
            last = v;
        }
        if (r > maxLen) {
            maxLen = r;
        }

        out.print(maxLen);
        out.flush();
    }
}
