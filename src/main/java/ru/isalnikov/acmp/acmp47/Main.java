package ru.isalnikov.acmp.acmp47;

/**
 * Наихудший делитель
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 23%) Будем говорить, что число a
 * лучше числа b, если сумма цифр a больше суммы цифр числа b, а в случае
 * равенства сумм их цифр, если число a меньше числа b. Например, число 124
 * лучше числа 123, так как у первого из них сумма цифр равна семи, а у второго
 * — шести. Также, число 3 лучше числа 111, так как у них равны суммы цифр, но
 * первое из них меньше.
 *
 * Дано число n. Найдите такой его делитель d (само число n и единица считаются
 * делителями числа n), что любой другой делитель c числа n лучше, чем d.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит целое число n (1 ≤ n ≤
 * 105000).
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

    private static int digSum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int answer = 1;
        int bestSum = 1;

        for (int i = 1; i <= Math.round(Math.sqrt(n)) + 1; i++) {
            if (n % i == 0) {
                int tmp;
                tmp = digSum(i);
                if (tmp > bestSum || (tmp == bestSum && i < answer)) {
                    answer = i;
                    bestSum = tmp;
                }
                tmp = digSum(n / i);
                if (tmp > bestSum || (tmp == bestSum && i < answer)) {
                    answer = n / i;
                    bestSum = tmp;
                }
            }
        }

        out.print(answer);
        out.flush();
    }

}
