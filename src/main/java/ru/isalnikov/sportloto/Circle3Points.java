package ru.isalnikov.sportloto;

/**
 * Дана окружность и 3 случайные точки на ней. Точки образуют вершины вписанного
 * треугольника. Посчитать вероятность того что центр окружности будет внутри
 * треугольника.
 *
 */
import java.util.Arrays;
import java.util.Random;

public class Circle3Points {

    private static Random random = new Random();

    private static double randomAngle() {
        return 0d + (360d - 0d) * random.nextDouble();
    }

    private static boolean generateResult() {
        double[] angles = new double[]{
            randomAngle(),
            randomAngle(),
            randomAngle()
        };
        Arrays.sort(angles);

        double a1 = angles[0];
        double a2 = angles[1];
        double a3 = angles[2];

        return a3 < a2 + 180 && a3 > a1 + 180d && a2 < a1 + 180d;
    }

    public static void main(String[] args) {
        int total = 10_000_000;
        int success = 0;

        for (int i = 0; i < total; i++) {
            success += generateResult() ? 1 : 0;
        }
        System.out.println(((double) success) / total);
    }

}
