package ru.isalnikov.acmp.acmp69;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Igor Salnikov
 *
 * На одном известном автозаводе страны N-мерики главный инженер-рационализатор
 * внес предложение вместо круглых колес использовать колеса в форме правильных
 * N-угольников. "При этом", — сказал он, "важным показателем качества такого
 * колеса будет разность между радиусом описанной окружности и радиусом
 * вписанной окружности." Причем колесо считается качественным, если его
 * показатель качества меньше единицы.
 *
 * Задано число N и длина A стороны N-угольного колеса. Необходимо определить:
 * является ли такое колесо качественным.
 *
 * Входные данные Входной файл INPUT.TXT содержит два натуральных числа: N и A
 * (3 ≤ N ≤ 1000, 1 ≤ A ≤ 1000).
 *
 * Выходные данные В выходной файл OUTPUT.TXT выведите «YES», если это
 * качественное колесо и «NO» в противном случае.
 *
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int a = (in.nextInt());
        int n = (in.nextInt());

        double k = a / 2 / Math.sin(Math.PI / n) * (1 - Math.cos(Math.PI / n));
        System.err.println(k);
        out.print(k < 1 ? "NO" : "YES");
        out.flush();
    }
}
