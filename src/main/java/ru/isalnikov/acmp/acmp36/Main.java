package ru.isalnikov.acmp.acmp36;

/**
 * Постулат Бертрана (теорема Бертрана-Чебышева, теорема Чебышева) гласит, что
 * для любого n > 1 найдется простое число p в интервале n < p < 2n. Такая
 * гипотеза была выдвинута в 1845 году французским математиком Джозефем
 * Бертраном (проверившим ее до n=3000000) и доказана в 1850 году Пафнутием
 * Чебышевым. Раманужан в 1920 году нашел более простое доказательство, а Эрдеш
 * в 1932 – еще более простое.
 *
 * Ваша задача состоит в том, чтобы решить несколько более общую задачу – а
 * именно по числу n найти количество простых чисел p из интервала n < p < 2n.
 *
 * Напомним, что число называется простым, если оно делится только само на себя
 * и на единицу.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит целое число n (2 ≤ n ≤ 50000).
 *
 *
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        BigInteger bi = new BigInteger(String.valueOf(n));
        int count = 0;
        while (bi.compareTo(BigInteger.valueOf(2 * n)) < 0) {
            bi = bi.nextProbablePrime();
            if (bi.compareTo(BigInteger.valueOf(2 * n)) < 0) {
                count++;
            }
        }
        out.print(count);
        out.flush();
    }

}
