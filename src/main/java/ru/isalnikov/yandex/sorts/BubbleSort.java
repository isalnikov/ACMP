package ru.isalnikov.yandex.sorts;

import java.util.Arrays;

/**
 * http://www.ibm.com/developerworks/ru/library/l-data_structures_04/
 * https://habrahabr.ru/post/247053/
 *
 *
 */
public class BubbleSort {

    public static void main(String[] args) {

        int array[] = {0, 4, 1, 3, 7, 6, 8, 9, 5, 2};
        System.out.println(Arrays.toString(array));
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                System.out.println(Arrays.toString(array));
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
