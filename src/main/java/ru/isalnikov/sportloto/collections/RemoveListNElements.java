package ru.isalnikov.sportloto.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author i.salnikov
 */
public class RemoveListNElements {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList(Arrays.asList(1,2,3,4,5,6,7,8));
        Collections.shuffle(list);
        int a1 = list.removeLast();
        int a2 = list.removeLast();
        int a3 = list.removeLast();
        System.out.printf("%d %d %d\n" , a1,a2,a3);
        Collections.sort(list);
        System.out.println(list);
    }
}
