package ru.isalnikov.acmp.acmp10;

/**
 * Вася в школе изучил квадратные уравнения и понял, как они легко решаются
 * путем вычисления дискриминанта. Но Петя поведал ему о методе решения
 * кубических уравнений вида A*X3 + B*X2 + C*X + D = 0. На факультативе по
 * математике Васе задали решить около ста уравнений как раз такого вида. Но, к
 * сожалению, Вася забыл формулы, о которых рассказывал ему Петя. Но Васе было
 * известно, что все корни уравнений – целые числа и находятся на отрезке [-100,
 * 100]. Поэтому у Васи есть шанс найти их методом перебора, но для этого ему
 * придется затратить уйму времени, т.к. возможно необходимо будет осуществить
 * перебор нескольких тысяч значений. Помогите Васе написать программу, которая
 * поможет ему найти корни кубических уравнений!
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
        long a, b, c, d;

        a = in.nextLong();
        b = in.nextLong();
        c = in.nextLong();
        d = in.nextLong();

        StringBuilder sb = new StringBuilder();
        for (int i = -100; i <= 100; i++) {
            if (a * i * i * i + b * i * i + c * i + d == 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(i);

            }
        }
        out.print(sb.toString());
    }
}
