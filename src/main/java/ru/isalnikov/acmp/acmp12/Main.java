package ru.isalnikov.acmp.acmp12;

/**
 * Всем известно, что дачники – народ странный, почти такой же, как и
 * программисты. Строят они свои дачи непонятно где, да и выращивают там
 * непонятно что и непонятно зачем. А уж как они туда добираются, это другая
 * история: кто на автобусе, кто на электричке, кто на автомобиле, ну а кто-то
 * вовсе пешком ходит от дома и до самого участка. Так что не стоит удивляться,
 * если вдруг Вы узнаете, что некое садоводческое товарищество располагается на
 * острове, а дачники добираются до него самолетом. Да еще и на этом острове
 * может не быть посадочной полосы, так что высадиться на остров можно, только
 * прыгая с парашютом (мы уж не рассматриваем то, как они возвращаются с дач
 * домой). Рассмотрим этот уникальный случай. Пилот всегда старается осуществить
 * высадку парашютистов таким образом, чтобы дачники приземлялись как можно
 * ближе к своим прямоугольным участкам. Пилоту интересно знать: сколько
 * дачников приземлится на свои участки? Помогите ему решить эту задачу!
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

    static int area(int ax, int ay, int bx, int by, int cx, int cy) {
        return Math.abs((by - ay) * (cx - ax) - (bx - ax) * (cy - ay));
    }
    
    static boolean ipolygon(int[] vertx, int[] verty, int testx, int testy) {
        int nvert = vertx.length;
        int i, j;
        boolean c = false;
        for (i = 0, j = nvert - 1; i < nvert; j = i++) {
            if (((verty[i] > testy) != (verty[j] > testy))
                    && (testx < (vertx[j] - vertx[i]) * (testy - verty[i]) / (verty[j] - verty[i]) + vertx[i])) {

            }

            c = !c;
        }
        return c;
    }

    static boolean polygon(int[] xp, int[] yp, float x, float y) {
        int nvert = xp.length;
        boolean c = false;
        for (int i = 0, j = nvert - 1; i < nvert; j = i++) {
            if ((((yp[i] <= y) && (y < yp[j])) || ((yp[j] <= y) && (y < yp[i])))
                    && (x > (xp[j] - xp[i]) * (y - yp[i]) / (yp[j] - yp[i]) + xp[i])) {
                c = !c;
            }
        }
        return c;
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = Integer.parseInt(in.nextLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            String[] s = in.nextLine().split(" ");

            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            //
            int x1 = Integer.parseInt(s[2]);
            int y1 = Integer.parseInt(s[3]);

            int x2 = Integer.parseInt(s[4]);
            int y2 = Integer.parseInt(s[5]);

            int x3 = Integer.parseInt(s[6]);
            int y3 = Integer.parseInt(s[7]);

            int x4 = Integer.parseInt(s[8]);
            int y4 = Integer.parseInt(s[9]);

            int[] vertx = new int[]{x1, x2, x3, x4};
            int[] verty = new int[]{y1, y2, y3, y4};
            //
//            long minx = Math.min(Math.min(Math.min(x1, x2),x3),x4);
//            long maxx = Math.max(Math.max(Math.max(x1, x2),x3),x4);
//            
//            long miny = Math.min(Math.min(Math.min(y1, y2),y3),y4);
//            long maxy = Math.max(Math.max(Math.max(y1, y2),y3),y4);

            
            int s0 = area(x1, y1, x2, y2, x3, y3)
                    + area(x1, y1, x3, y3, x4, y4);
            int s1 = area(x, y, x1, y1, x4, y4);
            int s2 = area(x, y, x1, y1, x2, y2);
            int s3 = area(x, y, x2, y2, x3, y3);
            int s4 = area(x, y, x3, y3, x4, y4);

            if (s1 + s2 + s3 + s4 - s0 <= 0) {
                result++;
            }
            
//            if (polygon(vertx, verty, x, y)) {
//                result++;
//            }

        }

        out.print(result);
    }

}
