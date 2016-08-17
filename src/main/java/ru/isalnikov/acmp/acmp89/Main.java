package ru.isalnikov.acmp.acmp89;

/**
 * Между двумя крупнейшими городами нашей страны Санкт-Петербургом и Москвой
 * ежедневно совершают рейсы n поездов. Для каждого поезда известно его время
 * отправления из Санкт-Петербурга и время прибытия в Москву.
 *
 * Найдите самый быстрый поезд и его скорость в предположении, что длина
 * железной дороги между Санкт-Петербургом и Москвой равна 650 км.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит целое число n (1 ≤ n ≤ 100).
 * Каждая из последующих n строк описывает ровно один поезд.
 *
 * Описание поезда состоит из его названия, времени отправления и времени
 * прибытия. Название поезда – строка длиной не более 50 символов, заключенная в
 * кавычки. Она может содержать буквы латинского алфавита, пробелы, цифры,
 * символы тире («–») и подчеркивания («_»). Время отправления и прибытия заданы
 * в формате ЧЧ:ММ. Строчные и заглавные буквы в названиях поездов различаются.
 *
 * Время в пути для каждого из поездов составляет хотя бы одну минуту и не
 * превышает 24 часов.
 *
 * Гарантируется, что самый быстрый поезд определяется единственным образом.
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = Integer.parseInt(in.nextLine().trim());
        String fastTainName = null;
        int fastSpeed = -1;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        long minTime = Long.MAX_VALUE;

        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);

        for (int i = 0; i < N; i++) {
           String  nextLine = in.nextLine();
           int index = nextLine.lastIndexOf("\"");
           
           String [] line = new String[3];
           
            line[0] = nextLine.substring(0, index+1);
            line[1] = nextLine.substring(index+2, index+2+5);
            line[2] = nextLine.substring(index+2+5+1, index+2+5+1+5);
            LocalTime startTime = LocalTime.parse(line[1], formatter);
            LocalTime stopTime = LocalTime.parse(line[2], formatter);

            LocalDateTime start = startOfDay.plusHours(startTime.getHour()).plusMinutes(startTime.getMinute());
            LocalDateTime stop;

            stop = startOfDay.plusHours(stopTime.getHour()).plusMinutes(stopTime.getMinute());
            if (stopTime.equals(startTime)  || stopTime.isBefore(startTime)) {
                stop = stop.plusDays(1);
            }

            long minutesBetween = ChronoUnit.MINUTES.between(start, stop);
            if (minutesBetween < minTime) {
                minTime = minutesBetween;
                fastTainName = line[0];
                fastSpeed = (int) Math.round(650.0 * 60 / minutesBetween);
            }
        }

        out.println(String.format("The fastest train is %s.", fastTainName));
        out.print(String.format("It's speed is %d km/h, approximately.", fastSpeed));
       out.flush();
    }

}
