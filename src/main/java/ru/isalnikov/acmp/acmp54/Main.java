package ru.isalnikov.acmp.acmp54;

/**
 * ЗАДАЧА №54 Теория игр
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 28%) Одним из интересных объектов,
 * изучаемых в теории игр, являются так называемые антагонистические игры двух
 * лиц. Такие игры характеризуются множеством X стратегий первого игрока,
 * множеством Y стратегий второго игрока и функцией выигрыша K(x, y) (x из X, y
 * из Y). Если множества стратегий X и Y конечны, то такую игру принято называть
 * матричной, так как функцию выигрыша K в этом случае удобно задавать матрицей.
 *
 * Рассмотрим матричную игру, в которой X = {1,…,n}, Y = {1,…,m}. Матрицу
 * выигрышей обозначим символом K. Нижним значением игры назовем число
 * maxi=1..nminj=1..m Kij . Верхним значением игры назовем число
 * minj=1..mmaxi=1..n Kij. Отметим также, что игры, у которых нижнее и верхнее
 * значение совпадают, называются играми с седловой точкой.
 *
 * Задана матрица выигрышей K для некоторой матричной игры. Найдите ее верхнее и
 * нижнее значение.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит целые числа n и m (1 ≤ n,m ≤
 * 100). Далее следуют n строк по m чисел в каждой. j-ое число i-ой строки равно
 * Kij . Все Kij по модулю не превосходят 1000.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите нижнее и верхнее значение игры через
 * пробел.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
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

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int a[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }

        int[] minn = new int[n];
        for (int i = 0; i < n; i++) {
            int[] row = a[i];
            minn[i] = Arrays.stream(row).min().getAsInt();
        }
        int max = Arrays.stream(minn).max().getAsInt();

        //
        int[] maxm = new int[m];

        for (int j = 0; j < m; ++j) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = a[i][j];
            }
            maxm[j] = Arrays.stream(col).max().getAsInt();

        }
        int min = Arrays.stream(maxm).min().getAsInt();

        out.print(String.format("%d %d", max, min));
        out.flush();
    }
}
