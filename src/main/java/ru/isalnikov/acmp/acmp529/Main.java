package ru.isalnikov.acmp.acmp529;

/**
 * Отрезок задан координатами своих концевых точек. Требуется вычислить длину
 * этого отрезка.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит координаты концов отрезка в формате X1 Y1 X2
 * Y2 . Все координаты – целые числа, не превышающие 1000 по абсолютной
 * величине.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите длину отрезка с точностью 10-5.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        
        int dx = x - x1;
        int dy = y - y1;
        double l = Math.sqrt(dx * dx + dy * dy );
        out.printf(Locale.ENGLISH,"%2.5f",l);
        out.flush();
    }

}
