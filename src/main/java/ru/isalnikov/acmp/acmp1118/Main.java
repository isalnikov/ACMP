package ru.isalnikov.acmp.acmp1118;

/**
 * Улитка ползет по вертикальному шесту высотой H метров, поднимаясь за день на
 * A метров, а за ночь спускаясь на B метров. На какой день улитка доползет до
 * вершины шеста?
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральные числа H, A и B. Ограничения: H ≤
 * 1000, B < A ≤ 100.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int H = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            out.print(Math.max(1 + (H - B- 1) /(A - B), 1)); // окркгление вверх 1 + ( (H - A) +  (A - B) -1) / (A - B)
            out.flush();
        }
    }

}
