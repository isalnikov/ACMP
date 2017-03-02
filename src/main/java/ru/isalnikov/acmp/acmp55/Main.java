package ru.isalnikov.acmp.acmp55;

/**
 * ЗАДАЧА №55 Фонарики
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 31%) «Одна голова хорошо, а две
 * лучше. Одна лампочка хорошо, а две лучше!» - подумал Миша, и решил собрать
 * фонарик с двумя лампочками. Теперь он хочет узнать, насколько фонарик с двумя
 * лампочками лучше, чем фонарик с одной. Для этого Миша посветил фонариком на
 * стену, и каждая из лампочек осветила на ней круг.
 *
 * Эффективность фонарика Миша хочет оценить через площадь освещенной части
 * стены. Миша догадался измерить координаты центров освещенных кругов и их
 * радиусы (которые оказались одинаковыми). Причем, площадь, освещаемая
 * фонариком с одной лампочкой известна, т.к. описана в документации,
 * прилагаемой к фонарику. Но что делать дальше он не знает. Напишите программу,
 * которая поможет Мише.
 *
 * Входные данные
 *
 * В первых двух строчках входного файла INPUT.TXT содержатся координаты (x1,y1)
 * и (x2,y2) - центры кругов от лампочек собранного Мишей фонарика. В третьей
 * строке задан радиус r описанных выше кругов, а четвертая строка содержит
 * площадь освещения s фонариком из одной лампочки. Все числа целые и
 * удовлетворяют следующим ограничениям: 1 ≤ x1,y1,x2,y2,r ≤ 100, 1 ≤ s ≤ 105.
 * Так же заметим, что площади, освещаемые разными фонариками, отличаются друг
 * от друга более чем на 10-3.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите «YES», если Мишин фонарик лучше старого
 * (т.е. освещает большую площадь) и «NO» в противном случае.
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

    private static void solve(Scanner in, PrintWriter out) {
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int r = in.nextInt();
        int s = in.nextInt();

        if ((x1 == x2) && (y1 == y2)) {
            if (r * r * Math.PI > s) {
                out.print("YES");
            } else {
                out.print("NO");
            }
            return;
        }

        double scmn = 0.0;
        if (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) >= 2 * r) {
            scmn = 0.0;
        } else {
            double m = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            double acos = m / (2 * r);
            double alpha = Math.acos(acos);
            double sect = (alpha / 2) * r * (m / 2);
            scmn = 4 * sect - r * r * Math.sin(alpha);
        }

        if ((2 * Math.PI * r * r - scmn) > s) {
            out.print("YES");
        } else {
            out.print("NO");
        }
        out.flush();
    }
}
