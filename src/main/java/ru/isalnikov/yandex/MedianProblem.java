// https://habrahabr.ru/post/247053/
package ru.isalnikov.yandex;

import java.util.Arrays;

public class MedianProblem {

    public static int med(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return a + b + c - max - min;

    }

    public static int med(int array[]) {

        Arrays.sort(array);

        if ((array.length & 1) == 1) {
            return array[array.length / 2];
        } else {
            return array[(array.length / 2 + (array.length / 2 + 1)) / 2];
        }

    }

    public static void main(String[] args) {

        System.out.println(med(1, 4, 7));
        System.out.println(med(1, 1, 100));

        int[] a = {0, 1, 2, 3, 4, 5 ,6};

        System.out.println(med(a));

        int[] b = {0, 1, 2, 3, 4, 5 ,6 ,7};

        System.out.println(med(b));

    }

}
