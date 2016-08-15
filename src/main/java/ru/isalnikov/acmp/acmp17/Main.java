package ru.isalnikov.acmp.acmp17;

/**
 * Для игры в «Поле чудес» используется круглый барабан, разделенный на сектора,
 * и стрелка. В каждом секторе записано некоторое число. В различных секторах
 * может быть записано одно и то же число. Однажды ведущий игры решил изменить
 * правила. Он сам стал вращать барабан и называть игроку (который барабана не
 * видел) все числа подряд в том порядке, в котором на них указывала стрелка в
 * процессе вращения барабана. Получилось так, что барабан сделал целое число
 * оборотов, то есть последний сектор совпал с первым. После этого, ведущий
 * задал участнику вопрос: какое наименьшее число секторов может быть на
 * барабане? Требуется написать программу, отвечающую на этот вопрос ведущего.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void prefixFunction(int[] array, int[] p) {
        for (int i = 1; i < array.length; ++i) {
            int j = p[i - 1];
            while (j > 0 && array[i] != array[j]) {
                j = p[j - 1];
            }
            if (array[i] == array[j]) {
                ++j;
            }
            p[i] = j;
        }

    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int[] array = IntStream.range(0, N).map(i -> in.nextInt()).toArray();
        int[] p = new int[N];
        prefixFunction(array,p);
        
        
        out.print(N - p[N-1]);
        out.flush();
    }



}
