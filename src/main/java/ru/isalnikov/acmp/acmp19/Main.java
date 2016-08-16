package ru.isalnikov.acmp.acmp19;

/**
 * На шахматной доске 8х8 расположены три фигуры: ферзь, ладья и конь. Требуется
 * определить количество пустых полей доски, которые находятся под боем. Для
 * простоты будем полагать, что фигуры могут «бить» через другие фигуры.
 * Например, в рассмотренной справа ситуации будем считать, что ферзь бьет D5
 * через ладью.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import static java.lang.Math.abs;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String[] pos = in.nextLine().split(" "); //Ф Л К 
        //A B C D E F G H  1 2 3 4 5 6 7 8 // "D1 D3 E5";
        int[][] doska = new int[8][8];
        
        int Fi = pos[0].charAt(0) - 65;
        int Fj = pos[0].charAt(1) - 49;
        
        int Li = pos[1].charAt(0) - 65;
        int Lj = pos[1].charAt(1) - 49;
        
        int Ki = pos[2].charAt(0) - 65;
        int Kj = pos[2].charAt(1) - 49;
        
        
        
        doska[Fi][Fj] = 2; //Ферзь 
        doska[Ki][Lj] = 2; //Ладья
        doska[Ki][Kj] = 2; //Конь

        //
        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska.length; j++) {

                if (doska[j][i] == 0) {

                    //Ферзь
                    if ((j ==  Fi || i == Fj) ||  (abs(j - Fi) == abs(i - Fj)))  {
                        doska[j][i] = 1;
                    }

                    //Ладья
                    if (j == Li || i == Lj) {
                        doska[j][i] = 1;
                    }

                    //Конь
                    if (abs((j - Ki) * (i - Kj)) == 2) {
                        doska[j][i] = 1;
                    }
                }
            }
        }

        int count = 0;
        // out.println();
        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska.length; j++) {
                if (doska[j][i] == 1) {
                    count++;
                }
                //     out.print(doska[j][i]);
            }
            //  out.println();
        }

        out.print(count);
        out.flush();
    }

}
