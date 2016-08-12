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
import java.util.Comparator;
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
        final int N = in.nextInt();
        int[] array = IntStream.range(0, N).map(i -> in.nextInt()).toArray();
        
        IntStream intStream = Arrays.stream(array);
        
        Comparator<? super Map.Entry<Integer, Long>> minByKeyAndMaxByValueComparator = (entry1, entry2) -> {
            int cmp = Long.compare(entry1.getValue(), entry2.getValue());
            if (cmp == 0) {
                cmp = Integer.compare(entry2.getKey(), entry1.getKey());
            }
            return cmp;
        };

        Optional<Entry<Integer, Long>> maxValue
                = intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .max(minByKeyAndMaxByValueComparator);

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
