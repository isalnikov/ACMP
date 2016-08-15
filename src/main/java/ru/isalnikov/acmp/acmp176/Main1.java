package ru.isalnikov.acmp.acmp176;

/**
 * Строка, состоящая из символов «(» и «)», называется скобочной
 * последовательностью. Скобочная последовательность называется правильной, если
 * она может быть получена из некоторого корректного арифметического выражения
 * удалением всех символов, кроме скобок. Например, правильная скобочная
 * последовательность «(())()» может быть получена из выражения
 * «(2-(3+4)*6)*(1+1)».
 *
 * Глубиной правильной скобочной последовательности называется максимальная
 * разность между количеством открывающихся и закрывающихся скобок в префиксе
 * последовательности (префиксом строки S называется строка, которую можно
 * получить из S удалением некоторого количества последних символов, например,
 * префиксами строки «ABCAB» являются строки «», «A», «AB», «ABC», «ABCA» и
 * «ABCAB»). Например, глубина последовательности «()()(())» равна двум, т.к.
 * префикс «()()((» имеет 4 открывающиеся и 2 закрывающиеся скобки.
 *
 * Требуется написать программу, определяющую по заданным значениям N и K
 * количество правильных скобочных последовательностей с N открывающимися
 * скобками, которые имеют глубину, равную K.
 *
 *
 *
 * http://e-maxx.ru/algo/bracket_sequences
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        final int n = 2 * in.nextInt();
        final int k = in.nextInt();
        BigInteger[][][] dp = new BigInteger[2][n + 1][n + 1];

        dp[0][0][0] = BigInteger.ONE;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {

                if (j > 0 && j < k) {
                    if (dp[0][i][j] == null) {
                        dp[0][i][j] = BigInteger.ZERO;
                    }

                    if (dp[0][i - 1][j - 1] == null) {
                        dp[0][i - 1][j - 1] = BigInteger.ZERO;
                    }

                    dp[0][i][j] = dp[0][i][j].add(dp[0][i - 1][j - 1]);
                }
                if (j < k) {

                    if (dp[0][i][j] == null) {
                        dp[0][i][j] = BigInteger.ZERO;
                    }
                    if (dp[0][i - 1][j + 1] == null) {
                        dp[0][i - 1][j + 1] = BigInteger.ZERO;
                    }

                    dp[0][i][j] = dp[0][i][j].add(dp[0][i - 1][j + 1]);
                }
            }
        }
        //
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (j > 0) {

                    if (dp[1][i][j] == null) {
                        dp[1][i][j] = BigInteger.ZERO;
                    }
                    if (dp[1][i - 1][j - 1] == null) {
                        dp[1][i - 1][j - 1] = BigInteger.ZERO;
                    }

                    dp[1][i][j] = dp[1][i][j].add(dp[1][i - 1][j - 1]);
                }
                if (j < k) {

                    if (dp[1][i][j] == null) {
                        dp[1][i][j] = BigInteger.ZERO;
                    }
                    if (dp[1][i - 1][j + 1] == null) {
                        dp[1][i - 1][j + 1] = BigInteger.ZERO;
                    }
                    dp[1][i][j] = dp[1][i][j].add(dp[1][i - 1][j + 1]);
                }
                if (j == k) {

                    if (dp[1][i][j] == null) {
                        dp[1][i][j] = BigInteger.ZERO;
                    }
                    if (dp[0][i - 1][j - 1] == null) {
                        dp[0][i - 1][j - 1] = BigInteger.ZERO;
                    }

                    dp[1][i][j] = dp[1][i][j].add(dp[0][i - 1][j - 1]);
                }
            }
        }

        out.print(dp[1][n][0]);
        out.flush();
    }

}
