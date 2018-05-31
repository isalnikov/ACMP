package ru.isalnikov.sqlru;

import java.util.Arrays;
import java.util.Random;

/**
 * Задачки на обход конем доски.
 * https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%85%D0%BE%D0%B4%D0%B5_%D0%BA%D0%BE%D0%BD%D1%8F
 * http://www.opita.net/node/921 http://5fan.ru/wievjob.php?id=49236
 *
 * @author Igor Salnikov
 */
public class NewClass {

    public static int N = 8;
    public static int count = 1;
    public static int[][] chessBoard = new int[N][N];
    public static int[][] arr = new int[N][N];
    public static int[] row = new int[N * N];

    public static int[] ktmov1 = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] ktmov2 = {1, 2, 2, 1, -1, -2, -2, -1};

    int i, j, move_num, d;

    public static int[][] horseDeltas = {
        {2, -1}, {2, 1},
        {-2, 1}, {-2, -1},
        {1, 2}, {1, -2},
        {-1, 2}, {-1, -2}};

    public static Random random = new Random(System.currentTimeMillis() / 3);

    public static void tryHorseJump(int x, int y) {

        
            chessBoard[x][y] =  count++;

            for (int[] dxdy : horseDeltas) {

                if (count == 64) {
                    print();
                    System.out.println("");
                    return;
                }

                int x1 = x + dxdy[0];
                int y1 = y + dxdy[1];

                if ((x1 >= 0 && x1 < N) && (y1 >= 0 && y1 < N) && chessBoard[x1][y1] == 0) {
                      
                    tryHorseJump(x1, y1);


                }

            }
        }
    

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(String.format("%02d", chessBoard[i][j]) + " ");

            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {

        int x = 0;
        random.nextInt(N);
        int y = 0;
        random.nextInt(N);
        System.out.println("Start");
        System.out.println(x + " " + y);

        tryHorseJump(x, y);

    }

}
