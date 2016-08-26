package ru.isalnikov.acmp.acmp327;

/**
 * Вова купил билет в трамвае 13-го маршрута и сразу посчитал суммы первых трёх
 * цифр и последних трёх цифр номера билета (номер у билета шестизначный).
 * Оказалось, что суммы отличаются ровно на единицу. «Я в одном шаге от
 * счастья», — подумал Вова, — «или предыдущий или следующий билет точно
 * счастливый». Прав ли он?
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит в первой строке число K – количество тестов.
 * В следующих K строках записаны номера билетов. Количество тестов не больше
 * 10. Номер состоит ровно из шести цифр, среди которых могут быть и нули.
 * Гарантируется, что Вова умеет считать, то есть суммы первых трех цифр и
 * последних трех цифр отличаются ровно на единицу.
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

    public static boolean isLucky(String s) {
        int a0 = Integer.parseInt("" + s.charAt(0));
        int a1 = Integer.parseInt("" + s.charAt(1));
        int a2 = Integer.parseInt("" + s.charAt(2));
        int s1 = a0 + a1 + a2;
        int b0 = Integer.parseInt("" + s.charAt(3));
        int b1 = Integer.parseInt("" + s.charAt(4));
        int b2 = Integer.parseInt("" + s.charAt(5));
        int s2 = b0 + b1 + b2;
        return s1 == s2;
    }

    private static void solve(Scanner in, PrintWriter out) {
        int K = Integer.parseInt(in.nextLine());

        for (int i = 0; i < K; i++) {
            String s = in.nextLine();

            int a = Integer.parseInt(s) + 1;
            int b = Integer.parseInt(s) - 1;
            String s1 = String.format("%06d", a);
            String s2 = String.format("%06d", b);

            if (isLucky(s1) || isLucky(s2)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.flush();
    }

}
