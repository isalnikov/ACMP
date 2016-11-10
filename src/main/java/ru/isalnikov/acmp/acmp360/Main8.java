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
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
 
class Main8 {
 
    static byte[][] a;
    static int l;
    static AtomicInteger max = new AtomicInteger(-301);
    static ExecutorService service =  Executors.newWorkStealingPool(4);
     
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
     
    static int D()
    {
      
 
        for (int i = 0; i < l; i++)
        {
            for (int j = 0; j < l; j++)
            {
                   
              final int k = i;
              final int n = j;
                Future<Integer> f = service.submit(()->G(k, n));
                try {
                     max .set(Math.max(max.get(),    f.get()));
                } catch (InterruptedException | ExecutionException e) {
                }
            }
        }
 
        return max.get();
    }
 
 
    static int G(int x, int y) {
        int lm = -301;
 
        if (x < l - 2) {
            int a1 = a[x][y] + a[x + 1][y] + a[x + 2][y];
            if (a1 > lm) {
                lm = a1;
            }
        }
 
        if (y < l - 2) {
            int a5 = a[x][ y] + a[x][ y + 1] + a[x][ y + 2];
            if (a5 > lm) {
                lm = a5;
            }
        }
 
        if (x == l - 1) {
            return lm;
        }
 
        if (y == l - 1) {
            return lm;
        }
 
        int a2 = a[x][ y] + a[x + 1][ y] + a[x + 1][ y + 1];
        if (a2 > lm) {
            lm = a2;
        }
 
        int a3 = a[x][ y] + a[x + 1][ y] + a[x][ y + 1];
        if (a3 > lm) {
            lm = a3;
        }
 
        int a4 = a[x][ y] + a[x][ y + 1] + a[x + 1][ y + 1 ];
        if (a4 > lm) {
            lm = a4;
        }
 
        int a6 = a[x + 1][ y + 1] + a[x][ y + 1] + a[x + 1][ y ];
        if (a6 > lm) {
            lm = a6;
        }
 
        return lm;
    }
 
    private static void solve(Scanner in, PrintWriter out) {
        l = in.nextInt();
        a = new byte[l][l];
        in.nextLine();
        for (int i = 0; i < l; i++) {
            
            String s = in.nextLine();
           int[] c = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            
            for (int j = 0; j < l; j++) {
                a[i][j] =(byte) c[j];
            }
        }
 
 
 
        out.print(D());
        out.flush();
    }
 
}