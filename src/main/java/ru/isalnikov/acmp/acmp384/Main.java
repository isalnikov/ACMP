package ru.isalnikov.acmp.acmp384;

/**
 * Последовательностью Фибоначчи называется последовательность чисел F0 = 0, F1
 * = 1, … , Fk = Fk-1 + Fk-2 (k > 1).
 *
 * Требуется найти наибольший общий делитель двух чисел Фибоначчи.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT записаны два целых числа i и j (1 ≤ i, j ≤ 106).
 *
 *
 */

//Основная идея: gcd(f[i], f[j]) = f[gcd(i, j)]. 6 тест - не забыть взять по модулю.

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public static BigInteger fibonacci(int number) {
        if (number == 1 || number == 2) {
            return BigInteger.ONE;
        }
        
        BigInteger fibo1 = BigInteger.ONE;
        BigInteger fibo2 = BigInteger.ONE;
        BigInteger fibonacci = BigInteger.ZERO;
        for (int i = 3; i <= number; i++) {
            fibonacci = fibo1.add(fibo2).mod(BigInteger.valueOf(1_000_000_000));
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            
            int a = in.nextInt();
            int b = in.nextInt();
            
            out.print(fibonacci(gcd(a,b)));

            out.flush();
        }
    }

}
