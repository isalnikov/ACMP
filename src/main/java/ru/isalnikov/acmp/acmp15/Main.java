package ru.isalnikov.acmp.acmp15;

/**
 * В галактике «Milky Way» на планете «Snowflake» есть N городов, некоторые из
 * которых соединены дорогами. Император галактики «Milky Way» решил провести
 * инвентаризацию дорог на планете «Snowflake». Но, как оказалось, он не силен в
 * математике, поэтому он просит вас сосчитать количество дорог. Требуется
 * написать программу, помогающую императору сосчитать количество дорог на
 * планете «Snowflake».
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int one = 0;
        for (int i = 0; i < N*N; i++) {
            if (in.nextInt() == 1) {
                one++;
            }
        }
        out.print(one/2);
        out.flush();
    }

}
