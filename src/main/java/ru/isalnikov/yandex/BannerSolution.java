/*
 http://www.slideshare.net/yaevents/ss-7255915
 */
package ru.isalnikov.yandex;

import java.util.Random;

public class BannerSolution {

    public static void main(String[] args) {
        Random r = new Random();
        int[] list = new int[100];// в угоду наглядности в дебри линкедлистов лезть не будем
        for (int i = 0; i < 100; ++i) {
            list[i] = i;
        }
        /*логика алгоритма*/
        int index = 99;
        int number;
        while (index > 0) {
            number = r.nextInt(index);
            System.out.println(list[number]);
            list[number] = list[index];
            --index;
        }
    }
}
