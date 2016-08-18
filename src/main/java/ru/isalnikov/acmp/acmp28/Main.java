package ru.isalnikov.acmp.acmp28;

/**
 * (Время: 1 сек. Память: 16 Мб Сложность: 19%) Многие из вас, вероятно, знакомы
 * с понятием симметрии относительно прямой. Пусть на плоскости расположена
 * прямая L и точка A. Точка B называется симметричной точке A относительно
 * прямой L, если отрезок АВ перпендикулярен прямой L и делится пополам точкой
 * пересечения с ней. В частности, если точка А лежит на прямой L, то точка B
 * совпадает с точкой А.
 *
 * Задана прямая L, параллельная одной из осей координат, и точка А. Найдите
 * точку В, симметричную А относительно L.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит 4 числа: x1, y1, x2, y2 –
 * координаты двух различных точек, через которые проходит прямая L. Вторая
 * строка входного файла содержит 2 числа xA и yA – координаты точки А. Все
 * числа во входном файле целые и не превосходят 108 по модулю.
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
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int xa = in.nextInt();
        int ya = in.nextInt();

        int x = xa, y = ya;

        if (x1 == x2) 
        {
            x = 2 * x1 - xa;
        }

        if (y1 == y2) 
        {
            y = 2 * y1 - ya;
        }

        out.print(x + " " + y);
        out.flush();
    }
}
