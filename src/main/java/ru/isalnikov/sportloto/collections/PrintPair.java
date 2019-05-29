package ru.isalnikov.sportloto.collections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author i.salnikov
 */
public class PrintPair {

    public static void main(String[] args) {
        int numbers = 45;
        
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= numbers; i++) {
            for (int j = 1; j <= numbers; j++) {

                if (i < j && i != j) {
                    System.out.printf("%02d#%02d ", i, j);
                } else {
                    System.out.printf("      ");
                }

            }
            System.out.println("");
        }
    }
}
