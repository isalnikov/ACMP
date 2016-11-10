/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex.sorts;

import java.util.Arrays;
import static java.util.Collections.swap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class QuickSort {

    public static Random rand = new Random(System.currentTimeMillis() / 3);

    public static void quickSort(List<Integer> array) {
        int n = array.size();
        int i = 0;
        int j = n - 1;
        int x = array.get(rand.nextInt(n));

        while (i <= j) {
            while (array.get(i) < x) {
                i++;
            }
            while (array.get(j) > x) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (j > 0) {
            quickSort(array.subList(0, j + 1));
        }
        if (i < n) {
            quickSort(array.subList(i, n));
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 1, 8, 6, 2, 3, 7, 4, 0, 5);
        quickSort(list);
        System.out.println(list);
    }

}
