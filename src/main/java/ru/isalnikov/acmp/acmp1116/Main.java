package ru.isalnikov.acmp.acmp1116;

/**
 * Даны значения двух моментов времени, принадлежащих одним и тем же суткам:
 * часы, минуты и секунды для каждого из моментов времени. Известно, что второй
 * момент времени наступил не раньше первого. Определите, сколько секунд прошло
 * между двумя моментами времени. Программа на вход получает три целых числа –
 * часы, минуты, секунды, задающие первый момент времени и три целых числа,
 * задающих второй момент времени. Выведите число секунд между этими моментами
 * времени.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит две строки, в каждой из них записан момент
 * времени: в первой строке – начальный, во второй – конечный. Каждое описание
 * времени состоит из трех целых неотрицательных чисел: H, M и S – часы, минуты
 * и секунды (H ≤ 23, M ≤ 59, S ≤ 59).
 *
 * https://www.youtube.com/watch?v=mUULQEKDaO8
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            int h1 = in.nextInt();
            int m1 = in.nextInt();
            int s1 = in.nextInt();

            int h2 = in.nextInt();
            int m2 = in.nextInt();
            int s2 = in.nextInt();

            LocalTime localTime1 = LocalTime.of(h1, m1, s1);
            LocalTime localTime2 = LocalTime.of(h2, m2, s2);
            out.print(Duration.between(localTime1, localTime2).get(ChronoUnit.SECONDS));

            out.flush();
        }
    }

}
