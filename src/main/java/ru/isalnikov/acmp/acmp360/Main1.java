package ru.isalnikov.acmp.acmp360;

/**
 * В данной двумерной целочисленной таблице размером N × N требуется найти три
 * элемента, сумма которых максимальна. При этом первый элемент должен быть
 * соседним по горизонтали или вертикали со вторым, а второй — с третьим.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит в первой строке число N (1 < N ≤ 2000). В
 * следующих N строках записано по N чисел – элементы таблицы. Элементы матрицы
 * по абсолютной величине не превышают 100.
 *
 * https://www.youtube.com/watch?v=aNKIt5C1DKg
 *
 */
//m:=b[i]+b[i+1]+a[i+1]; if m>max then max:=m; 
//m:=a[i]+b[i]+b[i+1]; if m>max then max:=m; 
//m:=a[i]+b[i+1]+a[i+1]; if m>max then max:=m; 
//m:=b[i]+a[i]+a[i+1]; if m>max then max:=m; 
//            
//a[i,j]+a[i,j-1]+a[i-1,j]>max 
//a[i,j]+a[i-1,j]+a[i-1,j-1]>max 
//a[i,j]+a[i,j-1]+a[i-1,j-1]>max 
//a[i,j]+a[i-1,j]+a[i-2,j]>max 
//a[i,j]+a[i,j-1]+a[i,j-2]>max 
//a[i,j]+a[i-1,j]+a[i-1,j+1]>max 
import java.io.*;
import java.util.*;

class Main1 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;
        byte[][] a = new byte[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextByte();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + 2 < n; j++) {
                max = Math.max(max, a[i][j] + a[i][j + 1] + a[i][j + 2]);
            }
        }
        for (int i = 0; i + 2 < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, a[i][j] + a[i + 1][j] + a[i + 2][j]);
            }
        }

        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j + 1 < n; j++) {
                max = Math.max(max, a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1]);
                max = Math.max(max, a[i][j] + +a[i][j + 1] + a[i + 1][j + 1]);
                max = Math.max(max, a[i][j] + a[i + 1][j] + a[i + 1][j + 1]);
                max = Math.max(max, a[i][j] + a[i + 1][j] + a[i][j + 1]);

            }
        }

        out.print(max);
        out.flush();
    }

}
