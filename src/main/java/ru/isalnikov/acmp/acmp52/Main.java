package ru.isalnikov.acmp.acmp52;

/**
 * Вы пользуетесь общественным транспортом? Вероятно, вы расплачивались за
 * проезд и получали билет с номером. Счастливым билетом называют такой билет с
 * шестизначным номером, где сумма первых трех цифр равна сумме последних трех.
 * Т.е. билет с номером 385916 – счастливый, т.к. 3+8+5=9+1+6. Вам требуется
 * написать программу, которая проверяет счастливость билета.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано одно целое число N (0
 * ≤ N < 106)..
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

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

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String s = in.nextLine();

        if (isLucky(s)) {
            out.print("YES");
        } else {
            out.print("NO");
        }
        out.flush();
    }

}
