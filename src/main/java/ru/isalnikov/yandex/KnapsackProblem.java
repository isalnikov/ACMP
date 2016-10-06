/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

 * http://neerc.ifmo.ru/wiki/index.php?title=%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%80%D1%8E%D0%BA%D0%B7%D0%B0%D0%BA%D0%B5
 * https://en.wikipedia.org/wiki/Knapsack_problem
 */
package ru.isalnikov.yandex;

import java.util.Arrays;

public class KnapsackProblem {

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int recursiveKnapSack(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return recursiveKnapSack(W, wt, val, n - 1);
        } // Return the maximum of two cases: 
        // (1) nth item included 
        // (2) not included
        else {
            return max(val[n - 1] + dynamicKnapSack(W - wt[n - 1], wt, val, n - 1),
                    recursiveKnapSack(W, wt, val, n - 1)
            );
        }
    }

    //
    static int[] values = new int[]{894, 260, 392, 281, 27};
    static int[] weights = new int[]{8, 6, 4, 0, 21};
    static int W = 30;
//recursion

    private static int knapsack(int i, int W) {
        if (i < 0) {
            return 0;
        }
        if (weights[i] > W) {
            return knapsack(i - 1, W);
        } else {
            return Math.max(knapsack(i - 1, W), knapsack(i - 1, W - weights[i]) + values[i]);
        }
    }

    // A Dynamic Programming based solution for 0-1 Knapsack problem 
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int dynamicKnapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        //System.out.println(knapsack(values.length - 1, W));

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(dynamicKnapSack(W, wt, val, n));

    }

    public static void slover(String[] args) {
        int W = 13;// Вместимость рюкзака
        int N = 5;// кол во элементов 
        int[] w = {3, 4, 5, 8, 9};
        int[] p = {1, 6, 4, 7, 6};
        int A[][] = new int[W + 1][N + 1];

        for (int k = 0; k < N; k++) {
            for (int s = 0; s < W; s++) {

                if (s >= w[k]) {  //Если текущий предмет вмещается в рюкзак
                    A[k][s] = Math.max(A[k][s], A[k - 1][s - w[k]] + p[k]); //выбираем класть его или нет
                } else {
                    A[k][s] = A[k][s];             //иначе, не кладем
                }

            }
        }

        System.out.println(Arrays.toString(A));

    }

}
