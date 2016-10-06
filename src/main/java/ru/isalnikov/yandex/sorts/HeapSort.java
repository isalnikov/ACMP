package ru.isalnikov.yandex.sorts;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringJoiner;
import java.util.TreeMap;
import static java.util.stream.Collectors.toList;

public class HeapSort {

    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public static void buildheap(int[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(a, i);
        }
    }

    public static void maxheap(int[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(int[] a0) {
        a = a0;
        buildheap(a);

        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {4, 1, 3, 2, 16, 9, 10, 0, 1, 14, 8, 7};

        int[] b1 = Arrays.stream(a1).toArray();
        sort(b1);

        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(a1));
        List<Integer> list = Arrays.stream(a1).boxed().collect(toList());
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (Integer key : list) {
            map.put(key, key);
        }

        System.out.println(map.values() + " set");

        List<Integer> list1 = Arrays.stream(a1).boxed().collect(toList());
        System.out.println(list1);
        PriorityQueue<Integer> queue = new PriorityQueue<>(list1);
       
        StringJoiner builder = new StringJoiner(",", "[", "]");
       
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            builder.add(String.valueOf(i));
        }
        
        System.out.println(builder.toString());
      

//        
     //   queue.stream().forEach(System.out::print);
        //System.out.print("]");
        //System.out.println("");
        
        

    }
}
