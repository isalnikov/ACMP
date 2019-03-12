
package ru.isalnikov.sportloto.collections;

import java.util.Arrays;

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
    }
}
