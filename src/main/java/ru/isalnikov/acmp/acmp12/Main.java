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


    
    private static void solve(Scanner in, PrintWriter out) {
      int N = Integer.parseInt(in.nextLine());

      int result = 0;
        for (int i = 0; i < N ; i++) {
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
            
            int minx = Math.min(Math.min(Math.min(x1, x2),x3),x4);
            int maxx = Math.max(Math.max(Math.max(x1, x2),x3),x4);
            
            int miny = Math.min(Math.min(Math.min(y1, y2),y3),y4);
            int maxy = Math.max(Math.max(Math.max(y1, y2),y3),y4);
            
            if(x>=minx && x <=maxx && y >= miny && y<= maxy) 
                result++;
            
        }
        

        out.print(result);
    }

}
