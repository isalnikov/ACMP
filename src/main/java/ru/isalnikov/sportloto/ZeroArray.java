package ru.isalnikov.sportloto;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Дан массив с целыми числами, среди которых есть нули. Сдвинуть все нули в
 * начало массива. ?
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class ZeroArray {

    public static void main(String[] args) {

        test1();
        System.exit(0);

    }

    private static void test3() {
        int[] array = Arrays.asList(1, 2, 0, 0, 3, 4, 0, 5, 1, 0, 9, 7, 0)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int i = array.length - 1;
        for (int j = i; j >= 0; j--) {
            if (array[j] != 0) {
                array[i--] = array[j];
            }
        }
        for (int ii = i; ii >= 0; ii--) {
            array[ii] = 0;
        }

        for (int ii = 0; ii < array.length; ++ii) {
            System.out.print(array[ii] + " ");
        }
    }

    public static void test() {

        int[] arr = {4, 0, 3, 0, 0, 6, 7, 0, 9, 0, 34, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                arr[j] = arr[i];
                arr[i] = 0;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void test1() {
        int[] array = new int[]{0, 12, 234, 0, 42, 5, 0};

        IntStream intStreamZero = Arrays.stream(array).filter(p -> p == 0);
        IntStream intStreamNonZero = Arrays.stream(array).filter(p -> p != 0);

        IntStream.concat(intStreamZero, intStreamNonZero).forEach(System.out::println);
    }
}
