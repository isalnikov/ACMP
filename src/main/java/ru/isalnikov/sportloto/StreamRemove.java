package ru.isalnikov.sportloto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class StreamRemove {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList();
        for (int i = 1; i < 10_000_000; i++) {
            nums.add(i);

        }

        List<Integer> filteredList;

        long start = System.currentTimeMillis();
        filteredList = nums.stream().filter(i -> i >= 3).collect(Collectors.toList());
        System.out.println(filteredList.size());
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms stream");

        start = System.currentTimeMillis();
        filteredList = nums.stream().filter(i -> i >= 3).collect(Collectors.toList());
        System.out.println(filteredList.size());
        stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms stream");

        start = System.currentTimeMillis();
        filteredList = nums.parallelStream().filter(i -> i >= 3).collect(Collectors.toList());
        stop = System.currentTimeMillis();
        System.out.println(filteredList.size());

        System.out.println((stop - start) + " ms parallelStream");

        start = System.currentTimeMillis();
        filteredList = nums.parallelStream().filter(i -> i >= 3).collect(Collectors.toList());
        stop = System.currentTimeMillis();
        System.out.println(filteredList.size());

        System.out.println((stop - start) + " ms parallelStream");

    }
}
