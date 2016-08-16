package ru.isalnikov.acmp.acmp18;

import java.io.PrintWriter;
import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter o = new PrintWriter(System.out); 
        int N = in.nextInt();
        o.print(TreeFactorial(N));
        o.flush();
    }
    public static BigInteger ProdTree(int l, int r) {
        if (l > r) {
            return ONE;
        }
        if (l == r) {
            return valueOf(l);
        }
        if (r - l == 1) {
            return valueOf(l).multiply(valueOf(r));
        }
        int m = (l + r) / 2;
        return ProdTree(l, m).multiply(ProdTree(m + 1, r));
    }
    public static BigInteger TreeFactorial(int n) {
            if (n < 2) {  return valueOf(1); }
        return ProdTree(2, n);
    }
}
