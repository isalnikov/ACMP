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
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static String[] names = {"Impossible", "Four of a Kind", "Full House", "Straight", "Three of a Kind", "Two Pairs", "One Pair", "Nothing"};

    private static void solve(Scanner in, PrintWriter out) {
        TreeMap<Integer, AtomicInteger> map = new TreeMap<>();
        String result = names[7];
        for (int i = 0; i < 5; i++) {
            int next = in.nextInt();
            map.putIfAbsent(next, new AtomicInteger(0));
            map.get(next).incrementAndGet();
        }

        if (map.keySet().size() == 1) {
            result = names[0];
        }

        if (map.keySet().size() == 2 && (map.firstEntry().getValue().get() == 4 || map.lastEntry().getValue().get() == 4)) {
            result = names[1];
        }
        if (map.keySet().size() == 2 && ((map.firstEntry().getValue().get() == 2 || map.lastEntry().getValue().get() == 3) || (map.firstEntry().getValue().get() == 3 || map.lastEntry().getValue().get() == 2))) {
            result = names[2];
        }

        if (map.keySet().size() == 3 && (map.firstEntry().getValue().get() == 2 || map.lastEntry().getValue().get() == 2)) {
            result = names[5];
        }

        if (map.keySet().size() == 3 && (map.firstEntry().getValue().get() == 3 || map.lastEntry().getValue().get() == 3 || (map.firstEntry().getValue().get() == 1 && map.lastEntry().getValue().get() == 1))) {
            result = names[4];
        }

        if (map.keySet().size() == 4) {
            result = names[6];
        }

        if (map.keySet().size() == 5 && (map.lastEntry().getKey() - map.firstEntry().getKey() == 4)) {
            result = names[3];
        }

        out.print(result);

        out.flush();
    }

}
