package ru.isalnikov.sportloto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static java.util.stream.Collectors.toList;

public class FillArray {

    public static void main(String[] args) {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<List<Integer>> bets = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            list.add(i);
        }
        while (bets.size() != 4) {
            Collections.shuffle(list, random);

            List<Integer> lst = list.stream().limit(4).collect(toList());
            if (check(lst)) {
                bets.add(lst);
                list.removeAll(lst);
            }

        }

        System.out.println(bets);

    }

    public static boolean check(List<Integer> list) {
        long even = list.stream().filter(x -> x % 2 == 0).count(); //четные
        long odd = list.stream().filter(x -> x % 2 == 1).count(); //нечетные
        long max = list.stream().filter(x -> x > 10).count(); //max
        long min = list.stream().filter(x -> x <= 10).count(); // min

        return even == odd && max == min;

    }
}
