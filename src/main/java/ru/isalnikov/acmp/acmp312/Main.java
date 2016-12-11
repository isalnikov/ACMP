package ru.isalnikov.acmp.acmp312;

/**
 * Заданы первый и второй элементы арифметической прогрессии. Требуется написать
 * программу, которая вычислит элемент прогрессии по ее номеру.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит три целых числа, разделенных пробелами –
 * первый элемент прогрессии A1 (1 ≤ A1 ≤ 1000), второй элемент прогрессии A2 (1
 * ≤ A2 ≤ 1000), и номер требуемого элемента N (1 ≤ N ≤ 1000).
 *
 * Выходные данные
 *
 * Выходной файл OUTPUT.TXT должен содержать одно целое число - N-й элемент
 * арифметической прогрессии.
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
        int a2 = in.nextInt();
        int n = in.nextInt();
        out.print(a1 + (a2 - a1) * (n - 1));
        out.flush();
    }
}
