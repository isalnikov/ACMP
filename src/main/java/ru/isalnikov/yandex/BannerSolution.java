/*
 http://www.slideshare.net/yaevents/ss-7255915
 */
package ru.isalnikov.yandex;

import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class BannerSolution {

    public static void main(String[] args) {

        //linkedListSolution();
        
        arraySolution();
    }

    public static void arraySolution() {
        Random r = new Random();
        int index = 100;
        int[] list = new int[index];
        for (int i = 0; i < index; ++i) {
            list[i] = i;
        }
        //System.out.println(Arrays.toString(list));
        int number;
        /*логика алгоритма*/
        while (index > 0) {
            number = r.nextInt(index) ;
            --index;
            int n = list[number];
            System.out.print(String.format(" %d",n));
            list[number] = list[index];
        }
    }

    public static void linkedListSolution() {
        LinkedList<Integer> list = new LinkedList();
        Random r = new Random();
         int index = 100;

        for (int i = 0; i < index; ++i) {
            list.add(i);
        }

        System.out.println(list);

        int number;
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (index > 0) {
            number = r.nextInt(index);
            --index;
            treeSet.add(list.get(number));
            list.set(number, list.get(index));
          
        }
        System.out.println("");
        System.out.println(treeSet);
    }
}
