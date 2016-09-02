package ru.isalnikov.acmp.acmp46;

/**
 * Выведите в выходной файл округленное до n знаков после десятичной точки число
 * E. В данной задаче будем считать, что число Е в точности равно
 * 2.7182818284590452353602875.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит целое число n (0 ≤ n ≤ 25).
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        String res = "7182818284590452353602875";
        
        char[] chars = res.toCharArray();
        if (n == 0) {
            res = "3";
            out.print(res);
            out.flush();
            return;
        } 
        if (n == 25) {
            out.print("2."+res);
            out.flush();
            return;
        }
        if(chars[n]>'4'){
          chars[n-1] =  Character.forDigit((Character.getNumericValue(chars[n-1]) + 1),10);
        }
        
        res ="2.";
        for (int i = 0; i < n; i++) {
            res = res + chars[i];
        }
            
        out.print(res);
        out.flush();
    }

}
