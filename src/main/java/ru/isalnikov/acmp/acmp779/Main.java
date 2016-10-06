/*
 Числа Фибоначчи

 (Время: 1 сек. Память: 16 Мб Сложность: 16%)
 Последовательностью Фибоначчи называется последовательность чисел a0, a1, ..., an, ..., где
 a0 = 0, a1 = 1, ak = ak-1 + ak-2 (k > 1).

 Требуется найти N-е число Фибоначчи.

 Входные данные

 Во входном файле INPUT.TXT записано целое число N (0 ≤ N ≤ 30).

 Выходные данные

 В выходной файл OUTPUT.TXT выведите N-е число Фибоначчи.


 https://habrahabr.ru/post/261159/
 */
package ru.isalnikov.acmp.acmp779;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            out.print(fibonacci(n));
            out.flush();
        }
    }

}
