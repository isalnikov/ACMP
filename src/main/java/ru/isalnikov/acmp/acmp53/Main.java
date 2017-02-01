package ru.isalnikov.acmp.acmp53;

/**
 * Таблицей умножения назовем таблицу размера n строк на m столбцов, в которой
 * на пересечении i-ой строки и j-ого столбца стоит число i∙j (строки и столбцы
 * нумеруются с единицы).
 *
 * В одной из математических школ было решено провести педагогический
 * эксперимент. Для того, чтобы ученикам было проще запоминать таблицу
 * умножения, некоторые числа в ней будут покрашены в красный, некоторые - в
 * синий, а некоторые - в зеленый цвет (оставшиеся числа будут черными).
 *
 * Процесс покраски чисел можно условно разбить на четыре этапа. На первом этапе
 * все числа красятся в черный цвет. На втором - все четные числа красятся в
 * красный цвет, на третьем – все числа, делящиеся на 3, красятся в зеленый
 * цвет, на четвертом - все числа, делящиеся на 5, красятся в синий цвет.
 *
 * Директор школы хочет знать, какое количество картриджей для принтеров
 * необходимо закупить для печати таблиц. Поэтому ему необходима информация о
 * том, сколько чисел какого цвета будет в одной раскрашенной таблице умножения
 * n на m. Напишите программу, решающую задачу подсчета соответствующих
 * количеств.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит два натуральных числа n и m (1 ≤ n,m ≤ 1000).
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<String, AtomicLong> map = new HashMap<>();

        map.putIfAbsent("RED", new AtomicLong(0));
        map.putIfAbsent("GREEN", new AtomicLong(0));
        map.putIfAbsent("BLUE", new AtomicLong(0));
        map.putIfAbsent("BLACK", new AtomicLong(0));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (i * j % 5 == 0) {

                    map.get("BLUE").incrementAndGet();
                } else if (i * j % 3 == 0) {
                    map.get("GREEN").incrementAndGet();
                } else if (i * j % 2 == 0) {
                    map.get("RED").incrementAndGet();
                } else {
                    map.get("BLACK").incrementAndGet();
                }

            }

        }

        out.println("RED : " + map.get("RED"));
        out.println("GREEN : " + map.get("GREEN"));
        out.println("BLUE : " + map.get("BLUE"));
        out.print("BLACK : " + map.get("BLACK"));
        out.flush();
    }

}
