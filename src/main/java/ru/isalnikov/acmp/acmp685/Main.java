package ru.isalnikov.acmp.acmp685;

/**
 * Сотрудники завода по производству золотого песка из воздуха решили поправить
 * свое финансовое положение. Они пробрались на склад завода, где хранился
 * золотой песок трех видов. Один килограмм золотого песка первого вида они
 * смогли бы продать за A1 рублей, второго вида – за A2 рублей, а третьего вида
 * – за A3 рублей. Так получилось, что у сотрудников оказалось с собой только
 * три емкости: первая была рассчитана на B1 килограмм груза, вторая на B2
 * килограмм, а третья на B3 килограмм. Им надо было заполнить полностью все
 * емкости таким образом, чтобы получить как можно больше денег за весь песок.
 * При заполнении емкостей нельзя смешивать песок разных видов, то есть, в одну
 * емкость помещать более одного вида песка, и заполнять емкости песком так,
 * чтобы один вид песка находился более чем в одной емкости.
 *
 * Требуется написать программу, которая определяет, за какую сумму
 * предприимчивые сотрудники смогут продать весь песок в случае наилучшего для
 * себя заполнения емкостей песком.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано 6 натуральных чисел
 * A1, A2, A3, B1, B2, B3, записанных в одной строке через пробел. Все числа не
 * превосходят 100.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int a3 = in.nextInt();
            int b1 = in.nextInt();
            int b2 = in.nextInt();
            int b3 = in.nextInt();

            int maxa = Math.max(Math.max(a1, a2), a3);
            int mina = Math.min(Math.min(a1, a2), a3);

            int mida = a1 + a2 + a3 - mina - maxa;

            int maxb = Math.max(Math.max(b1, b2), b3);
            int minb = Math.min(Math.min(b1, b2), b3);

            long midb = b1 + b2 + b3 - minb - maxb;

            out.print(maxa * maxb + mida * midb + mina * minb);
            out.flush();
        }
    }

}
