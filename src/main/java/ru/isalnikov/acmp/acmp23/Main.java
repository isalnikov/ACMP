package ru.isalnikov.acmp.acmp23;

/**
 * Как и многие другие девочки, Маша любит разные гадания. Некоторое время назад
 * Маша узнала новый способ гадать на числах – для какого-нибудь интересующего
 * ее натурального числа n надо посчитать сумму всех чисел, на которые n делится
 * без остатка. Маша не очень любит арифметику, и попросила вас написать
 * программу, которая автоматизирует процесс гадания.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано натуральное число n
 * (n ≤ 1000), которое Маша была вынуждена сообщить.
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
        int N = in.nextInt();
        int s = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                s += i;
            }
        }

        out.print(s);
        out.flush();
    }
}
