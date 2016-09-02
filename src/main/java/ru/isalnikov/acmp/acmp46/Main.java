package ru.isalnikov.acmp.acmp46;

/**
 * Выведите в выходной файл округленное до n знаков после десятичной точки число
 * E. В данной задаче будем считать, что число Е в точности равно
 * 2.7182818284590452353602875.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит целое число n (0 ≤ n ≤ 25).
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String res = "2.7182818284590452353602875";
        if (n == 0) {
            res = "3";
            out.print(res);
            out.flush();
            return;
        }
        if (n == 25) {
            out.print(res);
            out.flush();
            return;
        }
        String format = "0.";
        for (int i = 0; i < n; i++) {
       format = format + "0";

        }

        DecimalFormat df = new DecimalFormat(format);
        out.print(df.format(2.7182818284590452353602875).replace(",", "."));
        BigDecimal decimal = BigDecimal.valueOf(2.7182818284590452353602875);
 
       // out.print(decimal.setScale(n, RoundingMode.HALF_UP));
        out.flush();
    }

}
