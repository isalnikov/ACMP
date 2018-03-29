package ru.isalnikov.sportloto;

import java.util.Arrays;

/**
 * Дан массив с целыми числами, среди которых есть нули. Сдвинуть все нули в
 * начало массива. ?
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class ZeroArray {

    public static void main(String[] args) {
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
}
