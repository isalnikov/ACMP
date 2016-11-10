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

class Main {
   
   
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        
        int max = Integer.MIN_VALUE;
        int[] a = new int[n]; // <- 1 <-4
        int[] b = new int[n]; // <- 2 
        int[] c = new int[n]; // <- 3
        in.nextLine();
        for (int i = 0; i < n; i++) {

            int[] t = a;
            a = b;
            b = c;
            c = t;

            String s = in.nextLine();
            c = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            //    c = Arrays.asList(s.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < n; j++) {
                
                if((j + 2)  < n){
                   max = Math.max(max, c[j] + c[j + 1] + c[j + 2]);
                }
                
                if (i >= 1 && ((j + 1 ) < n)) {
                    
                    max = Math.max(max, b[j] + b[j + 1] + c[j + 1]);
                    max = Math.max(max, b[j] + b[j + 1] + c[j]);
                    max = Math.max(max, c[j] + c[j + 1] + b[j + 1]);
                    max = Math.max(max, c[j] + c[j + 1] + b[j]);
                }
  
                if (i >= 2) {
                    max = Math.max(max, a[j] + b[j] + c[j]);

                }
            }
        }
        out.print(max);
        out.flush();
    }

}
