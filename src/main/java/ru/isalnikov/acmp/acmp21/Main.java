package ru.isalnikov.acmp.acmp21;

/**
 * В отделе работают 3 сотрудника, которые получают заработную плату в рублях.
 * Требуется определить: на сколько зарплата самого высокооплачиваемого из них
 * отличается от самого низкооплачиваемого.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записаны размеры зарплат всех
 * сотрудников через пробел. Каждая заработная плата – это натуральное число, не
 * превышающее 105.
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

    private static void solve(Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        
        int min = Math.min(A, Math.min(B , C));
        int max = Math.max(A, Math.max(B , C));

        out.print(max - min);
        out.flush();
    }
}
