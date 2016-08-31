package ru.isalnikov.acmp.acmp42;

/**
 * Известно, что у дракона может быть несколько голов и его сила определяется
 * числом голов. Но как определить силу драконьей стаи, в которой несколько
 * драконов и у каждого из них определенное число голов? Вероятно, вы считаете,
 * что это значение вычисляется как сумма всех голов? Это далеко не так, иначе
 * было бы слишком просто вычислить силу драконьей стаи. Оказывается, что
 * искомое значение равно произведению значений числа голов каждого из драконов.
 * Например, если в стае 3 дракона, у которых 3, 4 и 5 голов соответственно, то
 * сила равна 3*4*5 = 60. Предположим, что нам известно суммарное значение голов
 * драконьей стаи, как нам вычислить максимально возможное значение силы этого
 * логова драконов? Именно эту задачу Вам и предстоит решить.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано натуральное число N
 * (0 < N < 100) – количество голов драконьей стаи.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
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

    public static long pw(int a, int k) {
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return a;
        }
        long res = pw(a, k / 2);
        res *= res;
        if (k % 2 == 1) {
            res *= a;
        }
        return res;
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        if (n < 3) {
            out.print(n);
            out.flush();
            return;
        }
        int x = n / 3;
        n -= x * 3;
        while (n % 2 != 0) {
            n += 3;
            x--;
        }
        int y = n / 2;
        long res = pw(3, x) * pw(2, y);
        out.print(res);
        out.flush();
    }

}
