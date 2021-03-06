package ru.isalnikov.acmp.acmp86;

/**
 * Вероятно, что многие из вас играли в шахматы. Поэтому вы знаете, что ферзь
 * может двигаться как по диагоналям, так и по горизонталям.
 *
 * Вася недавно начал заниматься шахматами и где-то прочел головоломку, в
 * которой нужно было расставить максимальное количество ферзей на доске 8х8
 * так, чтобы хотя бы одно поле оказалось небитым. Эта задача легко решается для
 * доски 3х3, т.к. понятно, что более двух ферзей расставить таким образом на
 * ней невозможно.
 *
 * Помогите Васе решить эту задачу для доски NxN.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано натуральное число N –
 * размеры шахматной доски NxN (1 ≤ N ≤ 100).
 *
 * Выходные данные
 *
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести максимальное
 * количество ферзей, которых можно расставить на шахматной доске NxN так, чтобы
 * одна клетка оставалась небитой.
 *
 *
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            int n = in.nextInt();
            out.print((n-1)*(n-2));
            out.flush();
        }
    }

}
