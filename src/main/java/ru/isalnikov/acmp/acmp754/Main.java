package ru.isalnikov.acmp.acmp754;

/**
 * Три толстяка решили поспорить: кто из них самый тяжелый. После взвешивания
 * оказалось, что их масса соответственно M1, M2 и M3 килограмм. Считается, что
 * масса толстяка должна быть не менее 94 и не более 727 килограмм.
 *
 * Помогите определить массу самого тяжелого из них, либо выяснить, что была
 * допущена ошибка при взвешивании.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит три целых числа M1, M2 и M3, разделенные
 * пробелом. Все числа целые и не превосходят 10 000 по абсолютной величине.
 *
 *
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
        int M1 = in.nextInt();
        int M2 = in.nextInt();
        int M3 = in.nextInt();

        int max = Math.max(Math.max(M1, M2), M3);
        int min = Math.min(Math.min(M1, M2), M3);
        if (min < 94 || max > 727) {
            out.print("Error");
        } else {
            out.print(max);
        }
        out.flush();
    }

}
