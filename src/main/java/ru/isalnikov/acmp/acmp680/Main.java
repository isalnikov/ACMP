package ru.isalnikov.acmp.acmp680;

/**
 * Садовник посадил N деревьев в один ряд. После посадки деревьев садовнику
 * нужно их покрасить. В его распоряжении есть краска трех цветов: белая, синяя
 * и оранжевая. Сколько способов покраски деревьев есть у него, если никакие два
 * соседних дерева нельзя красить в одинаковый цвет?
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записано одно натуральное
 * число - количество деревьев N (1 ≤ N ≤ 50).
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import static java.math.BigInteger.valueOf;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            out.print(valueOf(3).multiply(valueOf(2).pow(n - 1)));
            out.flush();
        }

    }

}
