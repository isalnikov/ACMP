package ru.isalnikov.acmp.acmp35;

/**
 * Однажды известный профессор обнаружил описания k конечных автоматов. По его
 * мнению, нетривиальность конечного автомата, имеющего n состояний и m
 * переходов, можно описать целым числом d = 19m + (n + 239)*(n + 366) / 2 . Чем
 * больше d, тем больший интерес для науки представляет изучение его свойств.
 *
 * Помогите профессору вычислить нетривиальность имеющихся у него автоматов.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит целое число k (1 ≤ k ≤ 10000)
 * – количество конечных автоматов. Следующие k строк содержат по два целых
 * числа ni (0 ≤ ni ≤ 1000) и mi (0 ≤ mi ≤ 26ni2) – число состояний и переходов
 * i-го автомата.
 *
 *
 */
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            
            int k = in.nextInt();
            int n[] = new int[k];
            int m[] = new int[k];
            for (int i = 0; i < k ; i++) {
              n[i] =  in.nextInt();
              m[i] =  in.nextInt();
              int d = 19*m[i]+(n[i]+239)*(n[i]+366)/2; 
              out.println(d);
            }

            out.flush();
        }
    }

}
