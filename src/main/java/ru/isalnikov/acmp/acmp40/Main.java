package ru.isalnikov.acmp.acmp40;

/**
 * Необходимо вычислить значение 2n.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано натуральное число n
 * (0 < n < 1000).
 *
 *
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            out.print(BigInteger.valueOf(2).pow(n));
            out.flush();
        }
    }

}
