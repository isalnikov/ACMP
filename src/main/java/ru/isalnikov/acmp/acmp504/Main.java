package ru.isalnikov.acmp.acmp504;

/**
 * (Время: 1 сек. Память: 16 Мб Сложность: 12%) В рождественский вечер на окошке
 * стояло три цветочка, слева на право: герань, крокус и фиалка. Каждое утро
 * Маша вытирала окошко и меняла местами стоящий справа цветок с центральным
 * цветком. А Таня каждый вечер поливала цветочки и меняла местами левый и
 * центральный цветок. Требуется определить порядок цветов ночью по прошествии K
 * дней.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT содержится натуральное число K – число дней (K
 * <=1000).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT требуется вывести три латинских буквы: «G», «C» и
 * «V» (заглавные буквы без пробелов), описывающие порядок цветов на окошке по
 * истечении K дней (слева направо). Обозначения: G – герань, C – крокус, V –
 * фиалка.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.joining;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        List<String> flowers = Arrays.asList("G","C","V"); 
        for (int i = 0; i < n; i++) {
            Collections.swap(flowers, 2, 1);
            Collections.swap(flowers, 0, 1);
            
        }
        out.print(flowers.stream().collect(joining("")));
        out.flush();
    }

}
