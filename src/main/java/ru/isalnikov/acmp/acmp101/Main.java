package ru.isalnikov.acmp.acmp101;

/**
 * Магараджа — это шахматная фигура, сочетающая возможности ферзя и коня. Таким
 * образом, магараджа может ходить и бить на любое количество клеток по
 * диагонали, горизонтали и вертикали (т.е. как ферзь), а также либо на две
 * клетки по горизонтали и на одну по вертикали, либо на одну по горизонтали и
 * на две по вертикали (как конь).
 *
 * Ваша задача — найти число способов расставить на доске N на N ровно K
 * магараджей так, чтобы они не били друг друга.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит два целых числа: N и K (1 ≤ K ≤ N ≤ 10).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите ответ на задачу.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int result = 0;
            out.print(result);
            out.flush();
        }
    }

}
