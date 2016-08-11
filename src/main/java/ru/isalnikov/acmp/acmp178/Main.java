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
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import static java.util.function.Function.identity;
import java.util.function.IntSupplier;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            int next = in.nextInt();
            array[i] = next;
        }
        
         IntStream intStream = Arrays.stream(array);
        
        // IntStream intStream = IntStream.range(0, N).map(i -> in.nextInt());
        
//              Comparator<? super Entry<Integer, Long>> maxValueComparator = (
//                entry1, entry2) -> entry1.getValue().compareTo(
//                        entry2.getValue());
// 
//        IntStream intStream = Arrays.stream(array);
// 
//        Optional<Entry<Integer, Long>> maxValue = intStream
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().max(maxValueComparator);
         

        Optional<Entry<Integer, Long>>  maxValue  =

                intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()) 
                .findFirst();
         


        intStream = Arrays.stream(array);

        IntSupplier intSupplier = () -> maxValue.get().getKey();

        IntStream maxIntStream = IntStream.generate(intSupplier).limit(maxValue.get().getValue());
        
        IntStream result = IntStream.concat(intStream.filter(i -> i != maxValue.get().getKey()), maxIntStream);
        
        
        String s = result
                .mapToObj(Integer::toString)
                .collect(joining(" "));
        
        out.print(s);
        out.flush();
    }

}
