package ru.isalnikov.acmp.acmp119;

/**
 * Требуется выполнить сортировку временных моментов, заданных в часах, минутах
 * и секундах.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT в первой строке записано число N (1<=N<=100), а в
 * последующих N строках N моментов времени. Каждый момент времени задается 3
 * целыми числами - часы (от 0 до 23), минуты (от 0 до 59) и секунды (от 0 до
 * 59).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите моменты времени, упорядоченные в порядке
 * неубывания без ведущих нулей..
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class Main {

//    public static Scanner in = new Scanner(System.in);
//    public static PrintStream out = System.out; 
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            int N = Integer.parseInt(in.nextLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String time = in.nextLine();
                String[] arr = time.split(" ");
                Integer itime = Integer.parseInt(arr[0]) * 60 * 60 + 60 * Integer.parseInt(arr[1]) + Integer.parseInt(arr[2]);
                list.add(itime);
            }

            list
                    .stream()
                    .sorted()
                    .map(i -> { return ""+ i/3600 + " "+ i%3600/60 + " "+i%3600%60; })
                    .collect(toList())
                    .forEach(out::println);
            out.flush();
        }
    }

}
