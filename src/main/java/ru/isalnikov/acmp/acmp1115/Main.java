package ru.isalnikov.acmp.acmp1115;

/**
 * N школьников желают разделить K яблок между собой. Они рассматривают два
 * способа дележа:
 *
 * разделить яблоки поровну так, чтобы каждому досталось максимальное количество
 * яблок, при этом оставшиеся яблоки можно положить в корзину; разделить все
 * яблоки так, чтобы количество яблок, доставшихся любым двум школьникам,
 * отличалось бы не более, чем на 1. В этом случае могут обидеться те из них,
 * кому достанется яблок меньше, чем другим. Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральные числа N и K – количество
 * школьников и яблок соответственно (N,K ≤ 109).
 *
 *
 * https://www.youtube.com/watch?v=mUULQEKDaO8
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

            int pupils = in.nextInt();
            int apples = in.nextInt();

            out.print((apples / pupils) + " " + (apples % pupils) + " " + (pupils - apples % pupils) % pupils );
            out.flush();
        }
    }

}
