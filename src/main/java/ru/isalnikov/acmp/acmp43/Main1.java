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

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String line = in.nextLine();
        int max = 0;
        int acc = 0;
        String zero = "";
        while (line.contains(zero)) {
            zero += "0";
        }
        out.print(zero.length() - 1);
        out.flush();
    }

}
