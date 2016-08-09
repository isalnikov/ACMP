package ru.isalnikov.acmp.acmp11;

/**
 * В нашем зоопарке появился заяц. Его поместили в клетку, и чтобы ему не было
 * скучно, директор зоопарка распорядился поставить в его клетке лесенку. Теперь
 * наш зайчик может прыгать по лесенке вверх, перепрыгивая через ступеньки.
 * Лестница имеет определенное количество ступенек N. Заяц может одним прыжком
 * преодолеть не более К ступенек. Для разнообразия зайчик пытается каждый раз
 * найти новый путь к вершине лестницы. Директору любопытно, сколько различных
 * способов есть у зайца добраться до вершины лестницы при заданных значениях K
 * и N. Помогите директору написать программу, которая поможет вычислить это
 * количество. Например, если K=3 и N=4, то существуют следующие маршруты:
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1. Т.е. при данных значениях у
 * зайца всего 7 различных маршрутов добраться до вершины лестницы.
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

          //a[n] = S (i=1;k)a[n-i] = a[n-1]+a[n-2]+....+a[n-k] //s min {k.n}
    //a[k] = 2^(k-1)
    private static void solve(Scanner in, PrintWriter out) {

        int k = in.nextInt();
        int n = in.nextInt();

        BigInteger[] a = new BigInteger[n + 1];
        a[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            int min = Math.min(k, i);
            a[i] = BigInteger.ZERO;
            for (int j = 1; j <= min; j++) {
                a[i] = a[i] .add(a[i - j]);
            }
        }

        out.print(a[n]);
    }

}
