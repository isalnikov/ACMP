package ru.isalnikov.acmp.acmp178;

/**
 * Задана последовательность, содержащая n целых чисел. Необходимо найти число,
 * которое встречается в этой последовательности наибольшее количество раз, а
 * если таких чисел несколько, то найти минимальное из них, и после этого
 * переместить все такие числа в конец заданной последовательности. Порядок
 * расположения остальных чисел должен остаться без изменения.
 *
 * Например, последовательность 1, 2, 3, 2, 3, 1, 2 после преобразования должна
 * превратиться в последовательность 1, 3, 3, 1, 2, 2, 2.
 *
 * Требуется написать программу, которая решает данную задачу.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int array[] = new int[N];

        ConcurrentHashMap<Integer, LongAdder> map = new ConcurrentHashMap<>();


        
        for (int i = 0; i < N; i++) {
            int next = in.nextInt();
            array[i] = next;
            map.computeIfAbsent(next, k -> new LongAdder()).increment();
        }
   
        Comparator<? super Entry<Integer, LongAdder>> maxValueComparator = (entry1, entry2) -> 
                 Integer.compare(entry1.getValue().intValue() , entry2.getValue().intValue());

        out.print(map);
        out.flush();
    }

}
