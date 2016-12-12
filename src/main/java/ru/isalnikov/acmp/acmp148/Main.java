package ru.isalnikov.acmp.acmp148;

/**
 * Даны два натуральных числа A и B. Требуется найти их наибольший общий
 * делитель (НОД).
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT в единственной строке записаны натуральные числа A
 * и B через пробел (A, B ≤ 109).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите НОД чисел А и В.
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

    /**
     * НОД (Наибольший общий делитель) или gcd (Greatest Common Divisor) НОД —
     * наибольшее число, которое является делителем одновременно для чисел a и
     * b. Реализация (Алгоритм Евклида):
     */
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static void solve(Scanner in, PrintWriter out) {

        int a = in.nextInt();
        int b = in.nextInt();

        out.print(gcd(a, b));
        out.flush();
    }

}
