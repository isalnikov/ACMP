package ru.isalnikov.acmp.acmp550;

/**
 * День программиста отмечается в 255-й день года (при этом 1 января считается
 * нулевым днем). Требуется написать программу, которая определит дату (месяц и
 * число григорианского календаря), на которую приходится День программиста в
 * заданном году.
 *
 * В григорианском календаре високосным является:
 *
 * год, номер которого делится нацело на 400 год, номер которого делится на 4,
 * но не делится на 100 Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано целое число от 1 до
 * 9999 включительно, которое обозначает номер года нашей эры.
 *
 * Выходные данные
 *
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести дату Дня
 * программиста в формате DD/MM/YYYY, где DD — число, MM — номер месяца (01 —
 * январь, 02 — февраль, ..., 12 — декабрь), YYYY — год в десятичной записи.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateTime = LocalDate.of(n, Month.JANUARY, 1).plusDays(255);
        out.print(dateTime.format(formatter));
        out.flush();
    }

}
