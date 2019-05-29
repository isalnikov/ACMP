
package ru.isalnikov.sportloto.collections;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author i.salnikov
 */
public class PairFlatMap {
    public static void main(String[] args) {
        int[][] data = { {1,2}, {3,4}, {5,6} };
        Arrays.stream(data)
                .limit(3)
                .flatMapToInt(Arrays::stream)
                ;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                int[] is = data[j];
                
            }
            
            
        }
        
        
        int[] a = IntStream.rangeClosed(1, 4).toArray();
        int size = a.length;
        for (int i1 = 0; i1 < size; i1++) {
            for (int i2 = i1 + 1; i2 < size; i2++) {
                String s = String.format("%d %d\n", a[i1], a[i2]);
                System.out.println(s);
            }

        }
        
    }
}
