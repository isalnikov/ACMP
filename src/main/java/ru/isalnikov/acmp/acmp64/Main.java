package ru.isalnikov.acmp.acmp64;

/**
 * Простым числом называется натуральное число (большее 1), 
 * которое делится нацело только на 1 и на само себя. Например, числа 2, 3, 5, 7, 11 и 23 - простые .
 * Назовем простым рядом последовательность цифр, полученную следующим образом: 
 * подряд идущие по возрастанию простые числа (начиная с 2) записываются друг за другом.
 * Начало данного ряда выглядит так: 23571113171923… Необходимо найти цифру, стоящую в простом ряду на указанном месте. 
 * Нумерация позиций начинается с единицы.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    
    public static String primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(x -> isPrime(x))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
    


    
    public static boolean isPrime(int x) {
        if (x < 3) {
            if (x <= 0) {
                return false;
            }
            if (x == 1) {
                return false;
            }
            if (x == 2) {
                return true;
            }
        }

        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }
 
    public static void main(String[] args) {

            try (Scanner in = new Scanner(System.in);
                    PrintWriter out = new PrintWriter(System.out)) {

                solve(in, out);
            }
    }

        private static void solve(Scanner in, PrintWriter out) {
            int n =in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();

            }

        
        String st = primeNumbersTill(25000);
        // [2] 35 [7] 111317 [1] 9232931374143475
        for (Integer it : arr) {
            out.print(st.charAt(it - 1));
        }
  
        out.flush();

    }
}
