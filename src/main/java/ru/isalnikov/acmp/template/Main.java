package ru.isalnikov.acmp.template;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
       int a = in.nextInt();
       int b = in.nextInt();
       out.println(a+b);
    }

}
