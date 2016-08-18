package ru.isalnikov.acmp.acmp30;

/**
 * Петя очень любит наблюдать за электронными часами. Он целыми днями смотрел на
 * часы и считал, сколько раз встречается каждая цифра. Через несколько месяцев
 * он научился по любому промежутку времени говорить, сколько раз на часах за
 * это время встретится каждая цифра, и очень гордился этим.
 *
 * Вася решил проверить Петю, но он не знает, как это сделать. Вася попросил Вас
 * помочь ему. Напишите программу, решающую эту задачу.
 *
 * Входные данные
 *
 * Первая и вторая строки входного файла INPUT.TXT содержат начало и конец
 * промежутка времени соответственно. Начальное время не превосходит конечное.
 * Время задается в формате hh:mm:ss (0 ≤ hh < 24, 0 ≤ mm < 60, 0 ≤ ss < 60).
 * hh, mm, ss дополнены ведущими нулями до двух символов. Эти нули также
 * учитываются при подсчете числа цифр.
 */
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static long[] a;

    private static void ncounting(LocalTime localTime) {
        localTime.format(DateTimeFormatter.ofPattern("HHmmss"))
                .replaceAll(":", "")
                .chars()
                .map(Character::getNumericValue)
                .mapToObj(Integer::valueOf)
                .collect(groupingBy(identity(), counting()))
                .forEach((k, v) -> {
                    a[k] = a[k] + v;
                });
    }

    private static void print(PrintWriter out) {
        for (int i = 0; i < a.length - 1; i++) {
            out.println(a[i]);
        }
        out.print(a[a.length - 1]);
        out.flush();
    }

    private static void solve(Scanner in, PrintWriter out) {
        a = new long[10];
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);

        String time1 = in.nextLine();
        String time2 = in.nextLine();

        LocalTime startTime = LocalTime.parse(time1);
        LocalTime stopTime = LocalTime.parse(time2);

        if (startTime.compareTo(stopTime) == 0) {
            ncounting(startTime);
            print(out);
            return;
        }

        LocalDateTime start = startOfDay.plusHours(startTime.getHour()).plusMinutes(startTime.getMinute()).plusSeconds(startTime.getSecond());
        LocalDateTime stop = startOfDay.plusHours(stopTime.getHour()).plusMinutes(stopTime.getMinute()).plusSeconds(stopTime.getSecond());
        if (stopTime.compareTo(startTime) <= 0) {
            stop = stop.plusDays(1);
        }
        ncounting(startTime);

        while (start.compareTo(stop) < 0) {
            start = start.plusSeconds(1);
            ncounting(start.toLocalTime());

        }

        print(out);
    }
}
