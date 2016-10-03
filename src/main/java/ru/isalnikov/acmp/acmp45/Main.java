package ru.isalnikov.acmp.acmp45;

/**
 * Требуется найти наименьшее натуральное число Q такое, что произведение его
 * цифр равно заданному числу N.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано одно целое число N (0
 * ≤ N ≤ 109).
 *
 * https://www.youtube.com/watch?v=mmhPgByJEyk
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
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

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        long result = 0;
        long pow = 1;

        
        if(n ==0){
            out.print("10");
            out.flush();
            return;
        }
        if(n < 10){
            out.print(n);
            out.flush();
            return;
        }
        
        for (int digit = 9; digit >= 2; digit--) {
            while (n % digit == 0) {
                n /= digit;
                result += digit * pow;
                pow *= 10;
            }

        }

        if (n == 1) {
            out.print(result);

        } else {
            out.print("-1");
        }
        out.flush();
    }
    
    
}


