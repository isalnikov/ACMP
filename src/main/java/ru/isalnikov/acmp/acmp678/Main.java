package ru.isalnikov.acmp.acmp678;



/**
 * Шулер показывает следующий трюк. Он имеет три одинаковых наперстка. Под
 * первый (левый) он кладет маленький шарик. Затем он очень быстро выполняет ряд
 * перемещений наперстков, каждое из которых – это одно из трех перемещений - A,
 * B, C:
 *
 * A - обменять местами левый и центральный наперстки, B - обменять местами
 * правый и центральный наперстки, C - обменять местами левый и правый
 * наперстки. Необходимо определить, под каким из наперстков окажется шарик
 * после всех перемещений.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записана строка длиной от 1 до
 * 50 символов из множества {A, B, C} – последовательность перемещений.
 *
 * Выходные данные
 *
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести номер
 * наперстка, под которым окажется шарик после перемещений.
 *
 * @author Igor Salnikov
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

    public static final void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void solve(Scanner in, PrintWriter out) {
        String combination = in.nextLine();
        int[] pos = new int[]{1, 0, 0};
        for (int i = 0; i < combination.length(); i++) {

            char ch = combination.charAt(i);
            switch (ch) {
                case 'A':
                    swap(pos, 0, 1);
                    break;
                case 'B':
                    swap(pos, 1, 2);
                    break;
                case 'C':
                    swap(pos, 0, 2);
                    break;

            }

        }
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 1) {
                out.print(i + 1);
                break;
            }

        }
        
        out.flush();
    }

}
