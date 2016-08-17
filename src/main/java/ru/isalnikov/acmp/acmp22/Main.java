package ru.isalnikov.acmp.acmp22;

/**
 * На уроках информатики вас, наверное, учили переводить числа из одних систем
 * счисления в другие и выполнять другие подобные операции. Пришло время
 * продемонстрировать эти знания. Найдите количество единиц в двоичной записи
 * заданного числа.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT записано целое число n (0 ≤ n ≤ 2*109).
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            out.print(Long.toBinaryString(in.nextInt()).replaceAll("0", "").length());
            out.flush();
        }
    }
}
