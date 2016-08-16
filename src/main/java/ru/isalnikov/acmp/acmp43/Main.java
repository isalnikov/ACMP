package ru.isalnikov.acmp.acmp43;

/**
 * Требуется найти самую длинную непрерывную цепочку нулей в последовательности
 * нулей и единиц.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записана последовательность
 * нулей и единиц (без пробелов). Суммарное количество цифр не превышает 100.
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
        String line = in.nextLine();
        int max = -1;
        int acc = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '0') {
                acc++;
            } else {
                acc = 0;
            }

            if (max < acc) {
                max = acc;
            }
        }

        out.print(max);
        out.flush();
    }

}
