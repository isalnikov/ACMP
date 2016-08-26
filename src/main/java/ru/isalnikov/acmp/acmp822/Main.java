package ru.isalnikov.acmp.acmp822;

/**
 * По целочисленным координатам вершин треугольника (x1,y1), (x2,y2) и (x3,y3)
 * требуется вычислить его площадь.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит 6 целых чисел x1,y1,x2,y2,x3,y3 – координаты
 * вершин треугольника. Все числа не превышают 106 по абсолютной величине.
 * <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();

            int x2 = in.nextInt();
            int y2 = in.nextInt();

            int x3 = in.nextInt();
            int y3 = in.nextInt();

            double result = Math.abs(0.5 * ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)));

            if (result == (int) result) {
                out.print((int) result);
            } else {
                out.print(result);
            }
            out.flush();
        }
    }

}
