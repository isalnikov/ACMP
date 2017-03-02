package ru.isalnikov.acmp.acmp1;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

 
    private static void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        out.println(a + b);
    }

}
