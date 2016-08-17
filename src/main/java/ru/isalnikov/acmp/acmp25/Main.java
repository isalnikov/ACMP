package ru.isalnikov.acmp.acmp25;

/**
 * Одна из основных операций с числами – их сравнение. Мы подозреваем, что вы в
 * совершенстве владеете этой операцией и можете сравнивать любые числа, в том
 * числе и целые. В данной задаче необходимо сравнить два целых числа.
 *
 * Входные данные
 *
 * В двух строчках входного файла INPUT.TXT записаны числа A и B, не
 * превосходящие по абсолютной величине 2*109.
 *
 * Выходные данные
 *
 * Запишите в выходной файл OUTPUT.TXT один символ “<”, если A < B, “>”, если A
 * > B и “=”, если A=B.
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
        long A = in.nextLong();
        long B = in.nextLong();

        if (A < B) {
            out.print("<");
        } else if (A == B) {
            out.print("=");
        } else {
            out.print(">");
        }

        out.flush();
    }
}
