package ru.isalnikov.acmp.acmp1113;

/**
 * аны два натуральных числа. Требуется проверить: делится ли одно из них на
 * другое?
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит два натуральных числа,
 * разделенных пробелом. Числа не превосходят 100.
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

            int a = in.nextInt();
            int b = in.nextInt();

            if (a % b == 0 || b % a == 0) {
                out.print(1);
            } else {
                out.print(666);
            }

            out.flush();
        }
    }

}
