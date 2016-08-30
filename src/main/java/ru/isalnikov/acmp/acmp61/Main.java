package ru.isalnikov.acmp.acmp61;

/**
 * Известны результаты каждой из 4х четвертей баскетбольной встречи. Нужно
 * определить победителя матча.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит 4 строки, в каждой строке находится два целых
 * числа a и b – итоговый счет в соответствующей четверти. а – количество
 * набранных очков за четверть первой командой, b – количество очков, набранных
 * за четверть второй командой. (0 ≤ a,b ≤ 100).
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

    private static void solve(Scanner in, PrintWriter out) {
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        int a2 = in.nextInt();
        int b2 = in.nextInt();
        int a3 = in.nextInt();
        int b3 = in.nextInt();
        int a4 = in.nextInt();
        int b4 = in.nextInt();

        int result = Integer.compare(a1 + a2 + a3+a4, b1 + b2 + b3+b4);
        if (result == 1) {
            out.print("1");
        } else if (result == -1) {
            out.print("2");
        } else {
            out.print("DRAW");
        }
        out.flush();
    }

}
