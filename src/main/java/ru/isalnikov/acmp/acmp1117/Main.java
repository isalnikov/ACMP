package ru.isalnikov.acmp.acmp1117;

/**
 * В некоторой школе занятия начинаются в 9:00. Продолжительность урока – 45
 * минут, после 1-го, 3-го, 5-го и т.д. уроков перемена длится 5 минут, а после
 * 2-го, 4-го, 6-го и т.д. – 15 минут.
 *
 * По номеру урока требуется определить время его окончания.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит целое число от 1 до 10 – номер урока.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            LocalTime localTime = LocalTime.of(9, 45);
            int i = 1;
            for (; i < n; i++) {
               int pause = ((i & 1)  == 1) ? 5 : 15;
               localTime = localTime.plusMinutes(pause).plusMinutes(45);
            }
            out.print(localTime.format(DateTimeFormatter.ofPattern("HH mm")));
            out.flush();
        }
    }

}
