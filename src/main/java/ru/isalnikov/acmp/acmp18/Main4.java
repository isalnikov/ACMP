package ru.isalnikov.acmp.acmp18;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter o = new PrintWriter(System.out);
        int N = in.nextInt();
        if (N < 2) {
            o.print(BigInteger.valueOf(1));
        } else {
            o.print(IntStream.rangeClosed(2, N).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get());
        }
        o.flush();
    }
}
