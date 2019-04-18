package ru.isalnikov.sportloto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {
        
int limit = 10;
int low = 1;
int high = 10;

        int[] array = new Random().ints(limit, low, high).toArray();
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (array[i] < array[j]) {
                    
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }

            }

        }
        
        System.out.println(Arrays.toString(array));
        
          ArrayList<String> list = new ArrayList<>(Arrays.asList("4",null,null,"0"));
    
        String aa = list.stream().filter(Objects::nonNull).sorted().collect(Collectors.joining());
        System.out.println(aa);
        
    }
    
    
  
    
    
}
