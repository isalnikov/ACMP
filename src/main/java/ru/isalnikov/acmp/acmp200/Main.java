package ru.isalnikov.acmp.acmp200;

/**
 * Марсианские факториалы
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 77%) В 3141 году очередная экспедиция
 * на Марс обнаружила в одной из пещер таинственные знаки. Они однозначно
 * доказывали существование на Марсе разумных существ. Однако смысл этих
 * таинственных знаков долгое время оставался неизвестным. Недавно один из
 * ученых, профессор Очень-Умный, заметил один интересный факт: всего в
 * надписях, составленных из этих знаков, встречается ровно K различных
 * символов. Более того, все надписи заканчиваются на длинную последовательность
 * одних и тех же символов.
 *
 * Вывод, который сделал из своих наблюдений профессор, потряс всех ученых
 * Земли. Он предположил, что эти надписи являются записями факториалов
 * различных натуральных чисел в системе счисления с основанием K. А символы в
 * конце – это конечно же нули – ведь, как известно, факториалы больших чисел
 * заканчиваются большим количеством нулей. Например, в нашей десятичной системе
 * счисления факториалы заканчиваются на нули начиная с 5! = 1·2·3·4·5 = 120. А
 * у числа 100! в конце следует 24 нуля в десятичной системе счисления и 48
 * нулей в системе счисления с основанием 6 – так что у предположения профессора
 * есть разумные основания!
 *
 * Теперь ученым срочно нужна программа, которая по заданным числам N и K найдет
 * количество нулей в конце записи в системе счисления с основанием K числа N! =
 * 1·2·3·…·(N-1)·N, чтобы они могли проверить свою гипотезу. Вам придется
 * написать им такую программу!
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит числа N и K, разделенные пробелом.
 * (1<=N<=109, 2<=K<=1000).
 *
 * Выходные данные
 *
 * Выведите в выходной файл OUTPUT.TXT число X - количество нулей в конце записи
 * числа N! в системе счисления с основанием K.
 *
 *
 * http://cppalgo.blogspot.ru/2011_04_01_archive.html
 * http://www.everfall.com/paste/id.php?c3v4qwjjtv2o
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    //TODO  найти max число степерь 5 в числе N
    private static int solve10(int N, int K) {
        int X = 0;
        int x = 5;
        while (true) {
            X += N / x;
            x *= 5;
            if (x > N) {
                break;
            }
        }
        return X;
    }

    private static long solveK(int N) {
        long res = (long) 1e9;
        for (int i : hmap.keySet()) {

            int mul = i;
            int cur_res = 0;

            while (true) {
                cur_res += N / mul;
                mul *= i;

                if (mul > N) {
                    break;
                }
            }

            cur_res /= hmap.get(i).get();

            res = Math.min(cur_res, res);

        }
        return res;
    }

    //private static int[] map = new int[1000];
    private static final TreeMap<Integer, AtomicInteger> hmap = new TreeMap<>();

    private static void findMuls(int k) {
        int cur = 2;
        int len = (int) Math.sqrt((double) k);
        while (cur <= len) {
            while (k % cur == 0) {
                k /= cur;
                len = (int) Math.sqrt((double) k);
                //   map[cur]++;
                hmap.putIfAbsent(cur, new AtomicInteger(0));
                hmap.get(cur).incrementAndGet();
            }
            cur++;
        }
        if (k != 1) {
            //  map[k]++;
            hmap.putIfAbsent(k, new AtomicInteger(0));
            hmap.get(k).incrementAndGet();
        }
    }

    private static void solve(Scanner in, PrintWriter out) {

        hmap.clear();
        int N = in.nextInt();
        int K = in.nextInt();
        findMuls(K);
        System.err.println(hmap);
        //out.print(solve10(N, K));
        out.print(solveK(N));
        out.flush();
    }
}
