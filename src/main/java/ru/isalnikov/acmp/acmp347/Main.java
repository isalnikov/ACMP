package ru.isalnikov.acmp.acmp347;

/**
 * Имеется 5 целых чисел. Среди них:
 *
 * • если одинаковы 5, то вывести "Impossible", иначе • если одинаковы 4, то
 * вывести "Four of a Kind", иначе • если одинаковы 3 и 2, то вывести "Full
 * House", иначе • если есть 5 последовательных, то вывести "Straight", иначе •
 * если одинаковы 3, то вывести "Three of a Kind", иначе • если одинаковы 2 и 2,
 * то вывести "Two Pairs", иначе • если одинаковы 2, то вывести "One Pair",
 * иначе • вывести "Nothing". Входные данные
 *
 * Входной файл INPUT.TXT содержит 5 целых чисел от 1 до 13, разделенных
 * пробелом.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static String[] names = {"Impossible", "Four of a Kind", "Full House", "Straight", "Three of a Kind", "Two Pairs", "One Pair", "Nothing"};

    private static void solve(Scanner in, PrintWriter out) {
        int[] array = new int[14];
        String result = names[7];
        int sum = 0;
        int min = 14;
        int max = 0;
        for (int i = 0; i < 5; i++) {
            int next = in.nextInt();
            //
            sum += next;
            //
            if (next < min) {
                min = next;
            }
            if (next > max) {
                max = next;
            }
            //
            array[next]++;
            if (array[next] == 5) {
                result = names[0];
            }
            if (array[next] == 4) {
                result = names[1];
            }
            if (array[next] == 3) {
                result = names[4];
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 2) {
                        result = names[2];
                    }
                }

            }
            if (array[next] == 2) {
                result = names[6];
                for (int j = 0; j < array.length; j++) {
                    if (i != j && array[j] == 2) {
                        result = names[5];
                    }
                }

            }

        }
        IntPredicate i = (x) -> x > 0;
       
        if ( ((min + max) * 5 / 2) == sum) {
            result = names[3];
        }

        out.print(result);
        out.flush();
    }

}
