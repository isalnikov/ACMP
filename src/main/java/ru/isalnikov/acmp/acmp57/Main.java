package ru.isalnikov.acmp.acmp57;

/**
 * (Время: 1 сек. Память: 16 Мб Сложность: 33%) Компания «Маша и медведи»
 * является самым крупным интернет-провайдером во всем лесу. Именно поэтому, с
 * просьбой подключить их к интернету обратились N поросят. Домики поросят
 * расположены в различных точках (xi, yi). Ближайшая точка подключения
 * расположена в точке (xnet, ynet).
 *
 * Для того чтобы подключиться к сети всем N поросятам необходимо: 1. провести
 * провод от точки подключения до домика одного из поросят; 2. от подключенного
 * поросенка провести провода ко всем остальным. При этом провода могут при
 * необходимости пересекаться. Поросята платят деньги в зависимости от длины
 * провода. Количество денег у них ограничено и составляет p тугриков. Они хотят
 * определить: хватит ли им денег на подключение? Так же известно, что единица
 * длины провода стоит c тугриков. Помогите им сделать необходимые расчеты!
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String ins = "3 2 6\n"
                + "0 0\n"
                + "1 0\n"
                + "0 1\n"
                + "-1 0";
        String ins2 = "3 1 5\n"
                + "1 1\n"
                + "2 2\n"
                + "3 3\n"
                + "4 4";

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private enum Answer {

        YES, NO;
    }

    private static class Pair {

        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("[%d ; %d]", x, y);
        }

    }

    public static double lens(Pair p1, Pair p2) {
        double x = Math.abs(p1.x - p2.x);
        double y = Math.abs(p1.y - p2.y);
        double z = Math.sqrt(x * x + y * y);
        return z;
    }

    private static void solve(Scanner in, PrintWriter out) {

        String[] s = in.nextLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        long p = Long.parseLong(s[2]);

        if (N < 0) {
            out.println(Answer.NO);
            return;
        }

        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            s = in.nextLine().split(" ");
            pairs[i] = new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        s = in.nextLine().split(" ");
        Pair net = new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

        //
        double len = 0.0;
        double eps = 0.0001;

        for (int i = 0; i < N; i++) {
            len = lens(pairs[i], net);
            for (int j = 0; j < N; j++) {
                len = len + lens(pairs[i], pairs[j]);
            }
            if (len * c - p < eps) {
                out.println(Answer.YES);
                return;
            }
        }
        out.println(Answer.NO);
    }

}
