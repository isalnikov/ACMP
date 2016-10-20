package ru.isalnikov.acmp.acmp106;

/**
 * На столе лежат n монеток. Некоторые из них лежат вверх решкой, а некоторые –
 * гербом. Определите минимальное число монеток, которые нужно перевернуть,
 * чтобы все монетки были повернуты вверх одной и той же стороной.
 *
 * Монетки Входные данные
 *
 * В первой строке входного файла INPUT.TXT записано натуральное число N (1 <= N
 * <= 100) – число монеток. В каждой из последующих N строк содержится одно
 * целое число – 1 если монетка лежит решкой вверх и 0 если вверх гербом.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите минимальное количество монет, которые
 * нужно перевернуть @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int  N = in.nextInt();
            int count = 0;
            for (int i = 0; i < N; i++) {
                  if(in.nextInt() == 1 ) count++;
            }
            out.print(Math.min(N-count, count));
            out.flush();
        }
    }

}
