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

//НОД (Наибольший общий делитель) или gcd (Greatest Common Divisor)
//НОД — наибольшее число, которое является делителем одновременно для чисел a и b.
//Реализация (Алгоритм Евклида):
    
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

//НОК (Наименьшее общее кратное) или lcm (Least Common Multiple)
//НОК — наименьшее число, которое делится на a и b без остатка.
//НОК можно найти через НОД по следующей формуле:  НОК(a,b) = (a*b)/НОД(a,b)
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
