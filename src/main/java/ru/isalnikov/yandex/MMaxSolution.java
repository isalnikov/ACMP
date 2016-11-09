package ru.isalnikov.yandex;

import java.util.Arrays;
import java.util.Iterator;
import ru.isalnikov.acmp.acmp224.LimitedQueue;

/**
 *
 * Найти K Максимумов в массиве из N элементов
 *
 * Решение для K=2 Решение для K=N/const
 * 
 * 
 * https://tproger.ru/problems/find-the-smallest-one-million-numbers-in-one-billion-numbers/
 */
public class MMaxSolution {

    public static int[] solution2(int a[]) {
        if (a == null || a.length < 3) {
            return a;
        }
        System.out.println(Arrays.toString(a));

        int max1 = Math.max(a[0], a[1]);
        int max2 = Math.min(a[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            if (a[i] > max1) {

                max2 = max1;
                max1 = a[i];
            } else if (a[i] > max2) {
                max2 = a[i];
            }

        }

        return new int[]{max1, max2};

    }

    public static int[] solution3(int a[], int k) {
        if (a == null || a.length == 0) {
            return a;
        }
        Arrays.sort(a);
        return Arrays.copyOfRange(a, a.length - k, a.length);

    }

    public static int[] solution4(int a[], int k) {
        // PriorityQueue  конечной емкости и
        // и скатьв ней бинарным поиском 
        // делать вставку и  удалять хвост 

        LimitedQueue queue = new LimitedQueue(k, Integer::compareTo);

        for (int i = 0; i < a.length; i++) {
            queue.add(a[i]);

        }
        int[] result = new int[k];
        int i = 0;
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            result[i++] = it.next();

        }
        return result;
    }

    
    public int partition(int[] array, int left, int right, int pivot) {
    while (true) {
        while (left <= right && array[left] <= pivot) {
            left++;
        }
    
        while (left <= right && array[right] > pivot) {
            right--;
        }
 
        if (left > right) {
            return left - 1;
        }
 
        swap(array, left, right);
    }
}
 


//public int rank(int[] array, int left, int right, int rank) {
//    int index = ThreadLocalRandom.current().nextInt(left, right + 1);
//    int pivot = array[index];
//    
//    /* Раздел и возврат конца левого раздела */
//    int leftEnd = partition(array, left, right, pivot);
//    
//    int leftSize = leftEnd - left + 1;
//    if (leftSize == rank + 1) {
//        return Math.max(array, left, leftEnd);
//    } else if (rank < leftSize) {
//        return rank(array, left, leftEnd, rank);
//    } else {
//        return rank(array, leftEnd + 1, right, rank - leftSize);
//    }
//}
//    
    public static void main(String[] args) {

        int[] a = {1, 4, 67, 8, 2, 1 - 4, 4, 57, 3, -44, 46};
        
        System.out.println(Arrays.stream(a).max().getAsInt());
        
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(solution3(a, 2)));
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(solution2(a)));
        System.out.println(Arrays.toString(solution4(a, 2)));
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(solution2(new int[]{1, 2, 3})));

    }

    private void swap(int[] array, int left, int right) {
        int tmpleft = array[left];
        int tmpright = array[right];

        array[left] = tmpright;
        array[right] = tmpleft;

    }

}
