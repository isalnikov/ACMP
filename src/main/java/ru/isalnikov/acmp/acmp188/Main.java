package ru.isalnikov.acmp.acmp188;

/**
 * Иван Иванович пригласил на свой день рождения много гостей. Он написал на
 * карточках фамилии всех гостей и разложил эти карточки на столе, полагая, что
 * каждый гость сядет там, где обнаружит карточку со своей фамилией (фамилии у
 * всех гостей различны). Однако гости не обратили внимания на карточки и сели
 * за стол в произвольном порядке. При этом Иван Иванович с удивлением
 * обнаружил, что ни один гость не сел на предназначенное ему место.
 *
 * Требуется написать программу, которая найдет сколькими способами можно
 * рассадить гостей так, чтобы ни один из них не сидел там, где лежала карточка
 * с его фамилией.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT задано целое число N – количество гостей (1 ≤ N ≤
 * 100).
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.math.BigInteger;
import static java.math.BigInteger.valueOf;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
           PrintWriter out = new PrintWriter(System.out)) {
            out.print(s(in.nextInt()));
            out.flush();
        }
    }

    public static BigInteger s(int i) {
        int sign = (i & 1) ==0 ? 1: -1;
        return i == 0 ? BigInteger.ONE : s(i-1).multiply(valueOf(i)).add(valueOf(sign));
    }
}
