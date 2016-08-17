package ru.isalnikov.acmp.acmp26;

/**
 * На плоскости даны две окружности. Требуется проверить, пересекаются ли они.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT состоит из двух строк. На каждой строке записана
 * информация об одной окружности – координаты ее центра x и y (целые числа, по
 * модулю не превосходящие 5000) и радиус (целое число 1 ≤ r ≤ 1000).
 */
import java.io.PrintWriter;
import static java.lang.Math.sqrt;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        long r1 = in.nextLong();

        long x2 = in.nextLong();
        long y2 = in.nextLong();
        long r2 = in.nextLong();

        double r = sqrt((x2 - x1) * ((x2 - x1)) + (y2 - y1) * (y2 - y1));

        if (r1 + r2 >= r && r + r2 >= r1 && r + r1 >= r2) {
            out.print("YES");
        } else {
            out.print("NO");
        }
        out.flush();
    }
}
