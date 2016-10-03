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
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            long mult = 1L;
            int N = in.nextInt();
            LimitedQueue maxLimitedQueue = new LimitedQueue(3, Comparator.<Integer>naturalOrder());
            LimitedQueue minLimitedQueue = new LimitedQueue(2, Comparator.<Integer>reverseOrder());

            for (int i = 0; i < N; i++) {
                int element = in.nextInt();
                maxLimitedQueue.add(element);
                minLimitedQueue.add(element);
            }

            long max = 1L;
            long maxelement = Long.MIN_VALUE;

            for (Integer element : maxLimitedQueue) {
                if (maxelement < element) {
                    maxelement = element;
                }
                max *= element;
            }

            long min = maxelement;
            for (Integer element : minLimitedQueue) {
                min *= element;
            }

            mult = Math.max(min, max);

            out.print(mult);
            out.flush();
        }
    }
}
