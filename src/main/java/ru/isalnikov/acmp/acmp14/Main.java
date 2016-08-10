package ru.isalnikov.acmp.acmp14;

/**
 * Требуется написать программу, определяющую наименьшее общее кратное (НОК)
 * чисел a и b.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    
    private static void solve(Scanner in, PrintWriter out) {

        int a = in.nextInt();
        int b = in.nextInt();
       
        out.print(lcm(a,b));
        out.flush();
    }

}
