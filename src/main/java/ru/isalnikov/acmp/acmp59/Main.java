package ru.isalnikov.acmp.acmp59;

/**
* Несложное вычисление
* Алгоритм решения задачи похож на перевод числа n в k-ую систему счисления. 
* При этом в процессе вычисления каждую полученную цифру можно прибавлять к некоторой переменной sum, а так же домножать к переменной mult. 
* В результате в sum получим сумму, а в mult произведение. Останется только вывести их разность.
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





    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int sum = 0; 
        int mult = 1;
        while (n>0) {            
            sum = sum + n  % k;
            mult = mult * (n  % k);
            n = n / k;
        }
       out.print(mult - sum);

        out.flush();
    }

}
