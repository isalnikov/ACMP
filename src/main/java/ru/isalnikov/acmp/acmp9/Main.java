package ru.isalnikov.acmp.acmp9;

/**
 * Петя успевает по математике лучше всех в классе, поэтому учитель задал ему
 * сложное домашнее задание, в котором нужно в заданном наборе целых чисел найти
 * сумму всех положительных элементов, затем найти где в заданной
 * последовательности находятся максимальный и минимальный элемент и вычислить
 * произведение чисел, расположенных между ними. Так же известно, что
 * минимальный и максимальный элемент встречаются в заданном множестве чисел
 * только один раз. Поскольку задач такого рода учитель дал Пете около ста, то
 * Петя как сильный программист смог написать программу, которая по заданному
 * набору чисел самостоятельно находит решение. А Вам слабо
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = Integer.parseInt(in.nextLine());
        String[] numbers = in.nextLine().split(" ");

        Integer[] arr = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        int minIndex = -1;
        int maxIndex = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i] ;
                minIndex = i;
            }

            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }

        }

       // int mult = 0;

        int sum = Arrays.stream(arr).filter(it -> it > 0).mapToInt(i -> i).sum();
        int mult = Arrays.stream(arr).skip(minIndex).limit(maxIndex - minIndex).reduce(1, Math::multiplyExact);

        out.print(sum + " " + mult);

    }

}
