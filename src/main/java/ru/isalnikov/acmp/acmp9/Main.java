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

        int minIndex = 0;
        int maxIndex = 0;

        int min = arr[0];
        int max = arr[0];

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
        
        for (int i = 0; i < arr.length; i++) {
            if (minIndex > maxIndex) {
                int temp = minIndex;
                minIndex = maxIndex;
                maxIndex = temp;
            }
        }
        
        int mult = 1;
        
        for (int i = minIndex+1; i < maxIndex; i++) {
            mult *= arr[i];

        }

       

        int sum = Arrays.stream(arr).filter(it -> it > 0).mapToInt(i -> i).sum();

        out.print(sum + " " + mult);

    }

}
