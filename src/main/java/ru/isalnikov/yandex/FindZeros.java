package ru.isalnikov.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * удалить все нолики
 *
 * тоже самое с массивом
 *
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class FindZeros {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 0, 0, 3, 4, 0, 5, 1, 0, 9, 7, 0));
        LinkedList<Integer> link = new LinkedList<>(list);

        ListIterator<Integer> it = link.listIterator();

        while (it.hasNext()) {
            if (it.next().equals(0)) {
                it.remove();
            }
        }

        list = new ArrayList<>(link);

        System.out.println(list);

        int[] array = Arrays.asList(1, 2, 0, 0, 3, 4, 0, 5, 1, 0, 9, 7, 0)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(array));

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[j++] = array[i];
            }
        }
        int[] newArray = new int[j];
        System.arraycopy(array, 0, newArray, 0, j);
        System.out.println(Arrays.toString(newArray));

    }

}
