package ru.isalnikov.acmp.acmp1114;

/**
 * Длина Московской кольцевой автомобильной дороги —109 километров. Байкер Вася
 * стартует с первого километра МКАД и едет со скоростью V километров в час. На
 * какой отметке он остановится через T часов?
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит два целых числа V и T –
 * скорость (км/ч) и время поездки в часах соответственно. Числа разделены
 * пробелом. Если V>0, то Вася движется в положительном направлении по МКАД,
 * если же значение V<0, то в отрицательном. Ограничения: |V| ≤ 1000, 0 ≤ T ≤
 * 1000.
 *
 * [1..109] km
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

            int v = in.nextInt();
            int t = in.nextInt();

            out.print(((v * t) % 109 + 109) % 109 + 1);
            out.flush();
        }
    }

}
