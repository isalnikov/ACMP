package ru.isalnikov.acmp.acmp412;

/**
 * Вася продолжает заниматься шахматами, и теперь он изучает различные
 * окончания. Оказалось, что компьютер очень удобно использовать для анализа
 * позиций. Теперь Вася просит вас написать программу, которая сможет
 * определить, что черный король находится под шахом.
 *
 * Для начала Васе подойдет программа, которая анализирует игровую ситуацию с
 * тем предположением, что на доске находятся три фигуры - белые король и ферзь
 * и черный король. Черный король находится под шахом, если белый ферзь может за
 * один ход попасть на занимаемую им клетку. Шахматный ферзь может перемещаться
 * по вертикали, горизонтали или диагонали, но, в отличие от коня, не может
 * “перепрыгивать” через другие фигуры.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записаны обозначения трех
 * клеток шахматной доски, разделенные пробелами: положения белого короля,
 * белого ферзя и черного короля соответственно. При этом гарантируется, что
 * черный и белый короли не находятся на соседних клетках.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите слово YES, если черный король находится
 * под шахом и NO, если шаха нет.
 *
 *
 */
import java.io.*;
import static java.lang.Math.abs;
import java.util.*;

class Main {

    public enum Result {

        YES, NO;

        public final static String letters = "ABCDEFGH";
        public final static String numbers = "12345678";

    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            String[] pos = in.nextLine().split(" ");
            String wk = pos[0];
            String wq = pos[1];
            String bk = pos[2];

            boolean isVertical  = wq.charAt(0) == bk.charAt(0); //  на одной Vertical 
            boolean isHorizontal = wq.charAt(1) == bk.charAt(1); //  на одной Horizontal

            boolean isDiagonal = abs(wq.charAt(0) - bk.charAt(0)) == abs(wq.charAt(1) - bk.charAt(1));
            
            //  проверить что он не между ними 
            int dx = abs(wq.charAt(0) - bk.charAt(0));
            int dxkwkb = abs(wk.charAt(0) - bk.charAt(0));
            int dxqkb = abs(wq.charAt(0) - wk.charAt(0));

            //  проверить что он не между ними 
            int dy = abs(wq.charAt(1) - bk.charAt(1));
            int dykwkb = abs(wk.charAt(1) - bk.charAt(1));
            int dyqkb = abs(wq.charAt(1) - wk.charAt(1));
            

            if (isHorizontal) {
                // проверить что между ними нет  белого короля
                isHorizontal = wq.charAt(1) == wk.charAt(1);

                if (!isHorizontal) {
                    out.print(Result.YES);
                } else {
         

                    if (dx == dxkwkb + dxqkb)  {
                        out.print(Result.NO);
                    } else {
                        out.print(Result.YES);
                    }
                }

            } else if (isVertical) {
                // проверить что между ними нет  белого короля
                isVertical = wq.charAt(0) == wk.charAt(0);

                if (!isVertical) {
                    out.print(Result.YES);
                } else {
                    //  проверить что он не между ними 
           

                    if (dy == dykwkb + dyqkb) {
                        out.print(Result.NO);
                    } else {
                        out.print(Result.YES);
                    }
                }
            }// Диагональ 
            else if (isDiagonal) {
                isDiagonal = abs(wq.charAt(0) - wk.charAt(0)) == abs(wq.charAt(1) - wk.charAt(1));
                if (!isDiagonal) {
                    out.print(Result.YES);
                } else {

         

                    if ((dx == dxkwkb + dxqkb) && (dy == dykwkb + dyqkb)) {
                        out.print(Result.NO);
                    } else {
                        out.print(Result.YES);
                    }

                }
            } else {
                out.print(Result.NO);
            }

            out.flush();
        }
    }
}
