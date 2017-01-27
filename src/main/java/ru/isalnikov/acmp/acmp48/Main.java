package ru.isalnikov.acmp.acmp48;

/**
 * Будем говорить, что число a лучше числа b, если сумма цифр a больше суммы
 * цифр числа b, а в случае равенства сумм их цифр, если число a меньше числа b.
 * Например, число 124 лучше числа 123, так как у первого из них сумма цифр
 * равна семи, а у второго – шести. Также, число 3 лучше числа 111, так как у
 * них равны суммы цифр, но первое из них меньше.
 *
 * Дано число n. Найдите такой его делитель (само число n и единица считаются
 * делителями числа n), который лучше любого другого делителя числа n.
 *
 * Входные данные
 *
 * Первая строка входного файла содержит целое число n (1 ≤ n ≤ 105).
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
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
        String n = in.next();
        int l = n.length() - 1;
        int cnt = 0;
        while (n.charAt(l) == '0') {
            cnt++;
            l--;
        }
        out.print(1);
        for (int i = 0; i < cnt; i++) {
            out.print(0);
        }
        out.flush();
    }

}
