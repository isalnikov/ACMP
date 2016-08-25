package ru.isalnikov.acmp.acmp692;

/**
 * Говорят, что плохой программист – это тот, кто считает, что в одном килобайте
 * 1000 байт, а хороший программист – это тот, кто полагает, что в одном
 * километре 1024 метра.
 *
 * Многим эта шутка понятна, так как все знают, что в процессах, связанных с
 * информатикой и компьютерной техникой, фигурирует множество значений,
 * выражаемых степенью двойки, то есть чисел вида 2K, где K – некоторое
 * неотрицательное целое число. Назовем такие числа бинарными. Это такие числа
 * как 2, 4, 8, 16, 32 и т.д. Действительно, когда речь идет о размере памяти
 * или о разрешении экрана монитора, то мы часто наталкиваемся на бинарные
 * числа. Все это связано с принципом хранения информации в памяти ЭВМ.
 *
 * Задано целое число N. Требуется определить, является ли оно бинарным.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит единственное целое число N, не превосходящее
 * 10000 по абсолютной величине.
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
            int a = in.nextInt();
            int z = 0;
            for (int n = 1; n < a; n = z) {
                z = 2 * n;
            }
            if (a == z && a >= 1 || a == 1) {
                out.print("YES");
            } else {
                out.print("NO");
            }
            out.flush();
        }

    }

}
