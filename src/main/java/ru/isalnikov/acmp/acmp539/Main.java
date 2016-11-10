package ru.isalnikov.acmp.acmp539;

/**
 * На свой день рождения Петя купил красивый и вкусный торт, который имел
 * идеально круглую форму. Петя не знал, сколько гостей придет на его день
 * рождения, поэтому вынужден был разработать алгоритм, согласно которому он
 * сможет быстро разрезать торт на N равных частей. Следует учесть, что разрезы
 * торта можно производить как по радиусу, так и по диаметру.
 *
 * Помогите Пете решить эту задачу, определив наименьшее число разрезов торта по
 * заданному числу гостей.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральное число N – число гостей, включая
 * самого виновника торжества (N <= 1000).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите минимально возможное число разрезов
 * торта.
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

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        out.print(n == 1 ? 0 : (n % 2 == 0 ? n / 2 : n));
        out.flush();
    }

}
