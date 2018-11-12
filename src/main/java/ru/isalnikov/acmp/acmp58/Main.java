package ru.isalnikov.acmp.acmp58;

/**
 * Рассмотрим таблицу, содержащую n строк и m столбцов, в каждой клетке которой
 * расположен ноль или единица. Назовем такую таблицу симпатичной, если в ней
 * нет ни одного квадрата 2 на 2, заполненного целиком нулями или целиком
 * единицами. Так, например, таблица 4 на 4, расположенная слева, является
 * симпатичной, а расположенная справа таблица 3 на 3 - не является. Задано
 * несколько таблиц. Необходимо для каждой из них выяснить, является ли она
 * симпатичной.
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private enum Answer {

        YES, NO;
    }

    private static Answer isNice(int n, int m, int[][] a) {

        boolean isNice = true;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {

                if ((a[i][j] + a[i][j + 1] + a[i + 1][j] + a[i + 1][j + 1]) % 4 == 0) {
                    isNice = false;
                }

            }

        }

        return isNice ? Answer.YES : Answer.NO;
    }

    private static void solve(Scanner in, PrintWriter out) {

        
        String ts = in.nextLine();
        int t = Integer.parseInt(ts);//1 < 10

        for (int it = 0; it < t; it++) {

            String nms = in.nextLine();
            int[] nm = Arrays.stream(nms.split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0];//1 < 100
            int m = nm[1];//1 < 100

            if (n <= 1 || m <= 1) {
                in.nextLine();
                out.println(Answer.YES);
                continue;
            }

            int matrix[][] = new int[n][m];
           
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
           
                int[] c = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < m; j++) {
                    matrix[i][j] = c[j];
                }
            }

            out.println(isNice(n, m, matrix));
        }

        out.flush();
    }

}
