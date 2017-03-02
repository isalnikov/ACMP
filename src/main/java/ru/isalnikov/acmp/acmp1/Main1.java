package ru.isalnikov.acmp.acmp1;

import java.io.*;
import java.util.*;
class Main1 {
    public static void main(String[] a) {
        try (Scanner i = new Scanner(System.in);
                PrintWriter o = new PrintWriter(System.out)) {
        o.println(i.nextInt() +i.nextInt());
        }
    }
}
