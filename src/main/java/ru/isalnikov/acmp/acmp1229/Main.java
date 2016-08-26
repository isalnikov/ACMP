package ru.isalnikov.acmp.acmp1229;

/**
 * Заданы целочисленные координаты вершин треугольника на плоскости. Необходимо
 * определить, является ли данный треугольник прямоугольным.
 *
 * Требуется решить данную задачу с использованием теоремы Пифагора, вычислив
 * квадраты длин сторон треугольника и проверив условие: a2+b2=c2. При этом
 * следует описать структуру Point для хранения координат точки на плоскости, а
 * также функцию Side(a,b), вычисляющую квадрат длины отрезка между парой точек.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT записаны через пробел координаты вершин
 * треугольника в формате x1 y1 x2 y2 x3 y3. Все числа целые, не превосходящие
 * 1000 по абсолютной величине.
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();

            int x2 = in.nextInt();
            int y2 = in.nextInt();

            int x3 = in.nextInt();
            int y3 = in.nextInt();

            double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
            double c = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

            double max = Math.max(Math.max(a, b), c);

            double alpha = 0;
            double betta = 0;
            double gamma = 0;

            alpha = (((Math.acos((b * b + c * c - a * a) / (2 * b * c)) * 180)) / Math.PI);
            betta = (((Math.acos((a * a + c * c - b * b) / (2 * a * c)) * 180)) / Math.PI);
            gamma = (((Math.acos((a * a + b * b - c * c) / (2 * a * b)) * 180)) / Math.PI);

            String result = "No";

            if ((a < (b + c) && b < (a + c) && c < (a + b)) //&& ((Double.compare(alpha, 90) == 0) || (Double.compare(betta, 90) == 0) || (Double.compare(gamma, 90) == 0))
                    ) {

                if (Double.compare(a * a + b * b, c * c) == 0) {
                    result = "Yes";
                } else if (Double.compare(b * b + c * c, a * a) == 0) {
                    result = "Yes";
                } else if (Double.compare(a * a + c * c, b * b) == 0) {
                    result = "Yes";
                }

            }
            out.print(result);
            out.flush();
        }
    }

}
