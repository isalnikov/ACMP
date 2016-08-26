package ru.isalnikov.acmp.acmp903;

/**
 * В шкатулке хранится разноцветный бисер (или бусины). Все бусины имеют
 * одинаковую форму, размер и вес. Бусины могут быть одного из N различных
 * цветов. В шкатулке много бусин каждого цвета.
 *
 * Требуется определить минимальное число бусин, которые можно не глядя вытащить
 * из шкатулки так, чтобы среди них гарантированно были две бусины одного цвета.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит одно натуральное число N - количество цветов
 * бусин (1 ≤ N ≤ 109).
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            long n = in.nextLong();
            out.print(n + 1);
            out.flush();
        }
    }

}
