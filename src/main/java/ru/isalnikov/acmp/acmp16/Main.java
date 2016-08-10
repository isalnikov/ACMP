package ru.isalnikov.acmp.acmp16;

/**
 * Лесенкой называется набор кубиков, в котором каждый более верхний слой
 * содержит кубиков меньше, чем предыдущий. Требуется написать программу,
 * вычисляющую число лесенок, которое можно построить из N кубиков.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static int kub(int n, int m) {
        int f = n == 0 ? 1 : 0;
        while (m < n) {
            m++;
            f += kub(n - m, m);
        }
        return f;
    }
    
    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
         out.print(kub(N, 0));
        out.flush();
    }

}
