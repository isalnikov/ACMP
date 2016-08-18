package ru.isalnikov.acmp.acmp27;

/**
 * Известный художник решил написать новый шедевр. После многих дней усердной
 * работы он захотел исследовать свое творение. Художник вспомнил, что картина
 * писалась следующим образом: сначала был взят белый холст, имеющий форму
 * прямоугольника шириной w и высотой h. Затем художник нарисовал на этом холсте
 * n прямоугольников со сторонами, параллельными сторонам холста и вершинами,
 * расположенными в целочисленных координатах. Помогите художнику определить
 * площадь незакрашенной части холста.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит два натуральных числа w и h
 * (1 ≤ w, h ≤ 100). Во второй строке записано целое число n (0 ≤ n ≤ 5000) –
 * количество прямоугольников. Следующие n строк содержат информацию о всех
 * прямоугольниках. Каждая строка описывает один прямоугольник в виде четырех
 * чисел x1, y1, x2, y2 , где (x1, y1) и (x2, y2) – координаты левого верхнего и
 * правого нижнего угла прямоугольника соответственно.
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
        int w = in.nextInt();
        int h = in.nextInt();
        int n = in.nextInt();

        int a[][] = new int[w][h];

        int size = w * h;
        for (int i = 0; i < n; ++i) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            for (int x = x1; x < x2; ++x) {
                for (int y = y1; y < y2; ++y) {
                    a[x][y] = 1;
                }
            }
        }
        //
        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (a[i][j] == 0) {
                    count++;
                }
            }
        }

        out.print(count);
        out.flush();
    }
}
