package ru.isalnikov.acmp.acmp224;

/**
 * Дано N целых чисел. Требуется выбрать из них три таких числа, произведение
 * которых максимально.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT записано сначала число N — количество чисел в
 * последовательности (3 ≤ N ≤ 106). Далее записана сама последовательность: N
 * целых чисел, по модулю не превышающих 30000.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите значение наибольшего произведения искомых
 * трех чисел.
 *
 *
 */

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            long mult = 1L;
            int N = in.nextInt();
            int [] array = new int[N];
            for (int i = 0; i <  N; i++) {
                array[i] = in.nextInt();
            }
            
            Arrays.sort(array);
            
            mult = Math.max(1L*array[0]*array[1]*array[array.length-1], 1L*array[array.length-3]*array[array.length-2]*array[array.length-1]);
            
            out.print(mult);
            out.flush();
        }
    }
}
