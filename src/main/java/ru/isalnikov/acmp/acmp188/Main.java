package ru.isalnikov.acmp.acmp188;

/**
 * Иван Иванович пригласил на свой день рождения много гостей. Он написал на
 * карточках фамилии всех гостей и разложил эти карточки на столе, полагая, что
 * каждый гость сядет там, где обнаружит карточку со своей фамилией (фамилии у
 * всех гостей различны). Однако гости не обратили внимания на карточки и сели
 * за стол в произвольном порядке. При этом Иван Иванович с удивлением
 * обнаружил, что ни один гость не сел на предназначенное ему место.
 *
 * Требуется написать программу, которая найдет сколькими способами можно
 * рассадить гостей так, чтобы ни один из них не сидел там, где лежала карточка
 * с его фамилией.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT задано целое число N – количество гостей (1 ≤ N ≤
 * 100).
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.math.BigInteger;
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
        out.print(subfactorial(n));
        out.flush();
    }
    
     public static BigInteger subfactorial(int x) {
        int i = x;
        int sign = 0;
        if (i % 2 == 1) {
            sign = -1;
        }
        if (i % 2 == 0) {
            sign = 1;
        }
        if (i == 0) {
            return BigInteger.ONE;
        }

        return subfactorial(i - 1).multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(sign));
    }
}
