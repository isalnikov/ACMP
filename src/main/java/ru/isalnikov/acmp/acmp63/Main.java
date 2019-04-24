package ru.isalnikov.acmp.acmp63;

/**
 * ИПетя и Катя – брат и сестра. Петя – студент, а Катя – школьница. Петя
 * помогает Кате по математике. Он задумывает два натуральных числа X и Y
 * (X,Y≤1000), а Катя должна их отгадать. Для этого Петя делает две подсказки.
 * Он называет сумму этих чисел S и их произведение P. Помогите Кате отгадать
 * задуманные Петей числа.
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
        int s = in.nextInt();
        int p = in.nextInt();
        for (int x = 1; x <= 1000; x++) {
          int y = s - x;
                if (x<=y && x * y == p) {
                    out.print(x + " " + y);
                    break;
                }
            

        }
        out.flush();

    }
}
