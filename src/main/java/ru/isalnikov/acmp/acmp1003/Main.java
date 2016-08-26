package ru.isalnikov.acmp.acmp1003;

/**
 * Однажды, посетив магазин канцелярских товаров, Вася купил X карандашей, Y
 * ручек и Z фломастеров. Известно, что цена ручки на 2 рубля больше цены
 * карандаша и на 7 рублей меньше цены фломастера. Также известно, что стоимость
 * карандаша составляет 3 рубля. Требуется определить общую стоимость покупки.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записаны три натуральных числа
 * X, Y и Z через пробел, каждое из которых не превышает 109.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            int costx = 3;
            int costy = costx + 2;
            int costz = costy + 7;

            out.print(x*costx+y*costy+z*costz);
            out.flush();
        }
    }

}
