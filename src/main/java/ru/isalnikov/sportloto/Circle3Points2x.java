package ru.isalnikov.sportloto;

/**
 * Дана окружность и 3 случайные точки на ней. Точки образуют вершины вписанного
 * треугольника. Посчитать вероятность того что центр окружности будет внутри
 * треугольника.
 *
 */
import java.util.Arrays;
import java.util.Random;

public class Circle3Points2x {

    private static Random random = new Random();

    private static double randomAngle() {
        return random.nextDouble();
    }

    private static boolean generateResult() {
        double[] points = new double[]{
            random.nextDouble(),
            random.nextDouble()
          
        };
        return points[0]<0.5 && points[1]>0.5 ||  points[0]>0.5 && points[1]<0.5;
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
